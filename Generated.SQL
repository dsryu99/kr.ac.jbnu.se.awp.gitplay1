/*
Created: 2021-10-10
Modified: 2021-12-06
Model: SirBay
Database: MySQL 8.0
*/

-- Create tables section -------------------------------------------------

-- Table User

CREATE TABLE `User`
(
  `userID` Char(20) NOT NULL,
  `userPassword` Char(20) NOT NULL
)
;

ALTER TABLE `User` ADD PRIMARY KEY (`userID`)
;

-- Table Question

CREATE TABLE `Question`
(
  `questionNum` Int(11) NOT NULL,
  `surveyID` Int NOT NULL,
  `questionDesc` Char(40) NOT NULL,
  `isEssential` Bool NOT NULL DEFAULT True,
  `isMultipleChoiceQuestion` Bool NOT NULL
)
;

ALTER TABLE `Question` ADD PRIMARY KEY (`questionNum`, `surveyID`)
;

-- Table Survey

CREATE TABLE `Survey`
(
  `surveyID` Int NOT NULL AUTO_INCREMENT,
  `userID` Char(20) NOT NULL,
  `surveyCreatedTime` Datetime NOT NULL,
  `surveyStartTime` Datetime,
  `surveyEndTime` Datetime,
  `surveyTitle` Char(20) NOT NULL,
  PRIMARY KEY (`surveyID`)
)
;

-- Table SurveyAnswer

CREATE TABLE `SurveyAnswer`
(
  `questionNum` Int(11) NOT NULL,
  `surveyID` Int NOT NULL,
  `answer` Char(40) NOT NULL DEFAULT 'not answered',
  `count` Int NOT NULL DEFAULT 0
)
;

ALTER TABLE `SurveyAnswer` ADD PRIMARY KEY (`questionNum`, `surveyID`, `answer`)
;

-- Table UserInfo

CREATE TABLE `UserInfo`
(
  `userID` Char(20) NOT NULL,
  `userName` Char(10) NOT NULL,
  `userBirthdate` Date NOT NULL,
  `userJob` Char(20) NOT NULL,
  `userAddress` Char(40),
  `userSex` Char(2) NOT NULL
)
;

ALTER TABLE `UserInfo` ADD PRIMARY KEY (`userID`)
;

-- Table MultipleChoiceQuestionItem

CREATE TABLE `MultipleChoiceQuestionItem`
(
  `itemNum` Int(11) NOT NULL,
  `questionNum` Int(11) NOT NULL,
  `surveyID` Int NOT NULL,
  `itemContent` Char(40) NOT NULL
)
;

ALTER TABLE `MultipleChoiceQuestionItem` ADD PRIMARY KEY (`itemNum`, `questionNum`, `surveyID`)
;

-- Table SurveyJoin

CREATE TABLE `SurveyJoin`
(
  `userID` Char(20) NOT NULL,
  `surveyID` Int NOT NULL,
  `joinDate` Datetime NOT NULL
)
;

ALTER TABLE `SurveyJoin` ADD PRIMARY KEY (`userID`, `surveyID`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `UserInfo` ADD CONSTRAINT `information` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`) ON DELETE CASCADE ON UPDATE RESTRICT
;

ALTER TABLE `SurveyAnswer` ADD CONSTRAINT `질문답변` FOREIGN KEY (`questionNum`, `surveyID`) REFERENCES `Question` (`questionNum`, `surveyID`) ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE `MultipleChoiceQuestionItem` ADD CONSTRAINT `질문문항` FOREIGN KEY (`questionNum`, `surveyID`) REFERENCES `Question` (`questionNum`, `surveyID`) ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE `Question` ADD CONSTRAINT `설문 내 질문` FOREIGN KEY (`surveyID`) REFERENCES `Survey` (`surveyID`) ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE `SurveyJoin` ADD CONSTRAINT `surveyJoin` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`) ON DELETE NO ACTION ON UPDATE RESTRICT
;

ALTER TABLE `SurveyJoin` ADD CONSTRAINT `작성기록` FOREIGN KEY (`surveyID`) REFERENCES `Survey` (`surveyID`) ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE `Survey` ADD CONSTRAINT `surveyCreating` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`) ON DELETE NO ACTION ON UPDATE RESTRICT
;

