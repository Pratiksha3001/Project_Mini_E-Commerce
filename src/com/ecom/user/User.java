package com.ecom.user;

public class User {

private int userId;	
private String firstName;
private String lastName;
private String userName;
private String UserPassword;
private String city;
private String mailId;
private Long mobileNumber;
private String userRole="User";

public User(String firstName, String lastName, String userName, String userPassword, String city, String mailId,
		Long mobileNumber,String userRole) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	UserPassword = userPassword;
	this.city = city;
	this.mailId = mailId;
	this.mobileNumber = mobileNumber;
	 this.userRole=userRole;
}

public User(String firstName, String lastName, String userName, String userPassword, String city, String mailId,
		Long mobileNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	UserPassword = userPassword;
	this.city = city;
	this.mailId = mailId;
	this.mobileNumber = mobileNumber;
}


public User() {
	   
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPassword() {
	return UserPassword;
}

public void setUserPassword(String userPassword) {
	UserPassword = userPassword;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getMailId() {
	return mailId;
}

public void setMailId(String mailId) {
	this.mailId = mailId;
}

public Long getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
			+ ", UserPassword=" + UserPassword + ", city=" + city + ", mailId=" + mailId + ", mobileNumber="
			+ mobileNumber + ", userRole=" + userRole + "]";
}


 

}
