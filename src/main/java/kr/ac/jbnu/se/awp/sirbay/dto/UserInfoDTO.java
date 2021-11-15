package kr.ac.jbnu.se.awp.sirbay.dto;

public class UserInfoDTO {
	private String userID;
	private String userName;
	private String userBirthdate;// form: yyyyMMdd
	private String userJob;
	private String userAddress;
	private int userSex;// male:0, female:1
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
	public String getUserAge() {
		return userBirthdate;
	}
	public void setUserAge(String userBirthdate) {
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
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
}
