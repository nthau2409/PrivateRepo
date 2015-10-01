package com.deutschwelle.fpt.videometrics.tasks;

import org.apache.http.HttpStatus;

import android.os.AsyncTask;

import com.deutschwelle.fpt.videometrics.AsynTaskNotificator;
import com.deutschwelle.fpt.videometrics.login.UserInformation;
import com.deutschwelle.fpt.videometrics.webservices.WebServiceResult;
import com.deutschwelle.fpt.videometrics.webservices.WebServices;

public class LoginTask extends AsyncTask<UserInformation, Double, Integer>
{
	private UserInformation userInfo = null;
	private AsynTaskNotificator mNotificator = null;
	
	private int resultStatus = HttpStatus.SC_BAD_REQUEST;
	
	public LoginTask(AsynTaskNotificator notificator){
		mNotificator = notificator;
	}
	
	@Override    	
	protected void onPreExecute() {
		mNotificator.onPreExecute();
		super.onPreExecute();
		
	}
	@Override
	protected Integer doInBackground(UserInformation... params) 
	{
		userInfo = params[0];
		String szUsername = userInfo.getUserName();
		String szPassword = userInfo.getPassword();
		
		WebServiceResult result = WebServices.login(szUsername, szPassword);
		resultStatus = result.getStatusCode();
		if(resultStatus != HttpStatus.SC_OK){
			return resultStatus;
		}
		
		String szAccessToken = result.getResult();
		WebServices.initializeProjectList(szUsername, szAccessToken);
		
		return resultStatus;
		
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		mNotificator.onPostExecute(result);
		super.onPostExecute(result);
	}
}