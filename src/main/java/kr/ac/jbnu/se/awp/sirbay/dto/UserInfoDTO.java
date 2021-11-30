package kr.ac.jbnu.se.awp.sirbay.dto;

import java.sql.Date;

public class UserInfoDTO {
	private String userID;
	private String userName;
	private Date userBirthdate;// form: yyyyMMdd
	private String userJob;
	private String userAddress;
	private String userSex;// male:남자, female:여자
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserAge() {
		return userBirthdate;
	}
	public void setUserAge(Date userBirthdate) {
		this.userBirthdate = userBirthdate;
	}
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
}
