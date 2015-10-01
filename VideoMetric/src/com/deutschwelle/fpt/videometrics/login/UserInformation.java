package com.deutschwelle.fpt.videometrics.login;

public class UserInformation {
	private String mUserName = "";
	private String mPassword = "";
	
	public UserInformation(String szUserName, String szPassword){
		mUserName = szUserName;
		mPassword = szPassword;
	}
	
	public String getUserName(){
		return mUserName;
	}
	
	public void setUserName(String szUserName){
		mUserName = szUserName;
	}
	
	public String getPassword(){
		return mPassword;
	}
	
	public void setPassword(String szPassword){
		mPassword = szPassword;
	}
}
