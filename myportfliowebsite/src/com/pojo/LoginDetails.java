package com.pojo;

public class LoginDetails {
	private int sno;
	private String userId;
	private String password;
	
	public LoginDetails() {
	
	}
	
	public LoginDetails(int sno, String userId, String password) {
		super();
		this.sno = sno;
		this.userId = userId;
		this.password = password;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "LoginDetails [sno=" + sno + ", userId=" + userId + ", password=" + password + "]";
	}
}
