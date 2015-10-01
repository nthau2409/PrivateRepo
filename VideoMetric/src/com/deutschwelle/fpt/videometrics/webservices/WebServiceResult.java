package com.deutschwelle.fpt.videometrics.webservices;

public class WebServiceResult {
	private int mStatusCode;
	private String mResult;
	
	public WebServiceResult(int statusCode, String result){
		mStatusCode = statusCode;
		mResult = result;
	}

	public int getStatusCode() {
		return mStatusCode;
	}

	public void setStatusCode(int statusCode) {
		this.mStatusCode = statusCode;
	}

	public String getResult() {
		return mResult;
	}

	public void setResult(String result) {
		this.mResult = result;
	}
	
	
}
