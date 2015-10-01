package com.deutschwelle.fpt.videometrics.webservices;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.deutschwelle.fpt.videometrics.projects.ProjectMaker;
import com.deutschwelle.fpt.videometrics.utils.StringUtils;

public class WebServices {
	
	private static HttpClient httpClient = new DefaultHttpClient();
	
	public static WebServiceResult login(String szUsername, String szPassword){
		
		HttpPost httpPost = new HttpPost("http://videometricsdev.azurewebsites.net//Token");
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.setHeader("Cache-Control", "no-cache");
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(3);
		nameValuePair.add(new BasicNameValuePair("username", szUsername));
		nameValuePair.add(new BasicNameValuePair("password", szPassword));
		nameValuePair.add(new BasicNameValuePair("grant_type", "password"));
		
		//Encoding POST data
		try {
		      httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		 
		} catch (Exception e) 
		{
		     e.printStackTrace();
		}
		
		try {
		    HttpResponse response = httpClient.execute(httpPost);
		    InputStream inputStream = response.getEntity().getContent();
		    
		    int nStatusCode = response.getStatusLine().getStatusCode();
		    String szContentResult = StringUtils.ConvertStreamToString(inputStream);
		    String szAccessToken = getAccessToken(szContentResult);
		    
		    return new WebServiceResult(nStatusCode, szAccessToken);
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return null;
	}
	
	public static void initializeProjectList(String szUsername, String szToken){
		
		String url = "http://videometricsdev.azurewebsites.net/api/Project/GetByUsername?username=" + szUsername;
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
		
		String authorizationInfo = "Bearer " + szToken;
		httpGet.setHeader("Authorization", authorizationInfo);
		
		try {
		    HttpResponse response = httpClient.execute(httpGet);
		    InputStream inputStream = response.getEntity().getContent();
		    
		    String szProjectList = StringUtils.ConvertStreamToString(inputStream);
		    
		    JSONArray jsonArrObj = new JSONArray(szProjectList);
			ProjectMaker projMaker = new ProjectMaker(jsonArrObj);
			projMaker.process();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} 
	}
	
	private static String getAccessToken(String szResponseContent){
		try {
			JSONObject jsonObj = new JSONObject(szResponseContent);
			return jsonObj.getString("access_token");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "";
	}
}
