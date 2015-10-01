package com.deutschwelle.fpt.videometrics;

public class Application {
	private static String mToken = "";
	private static String mUsername = "";

	public static String getToken() {
		return mToken;
	}

	public static void setToken(String token) {
		mToken = token;
	}
	
	public static String getUsername(){
		return mUsername;
	}
	
	public static void setUsername(String username){
		mUsername = username;
	}
}
