package com.deutschwelle.fpt.videometrics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.json.JSONObject;

import com.deutschwelle.fpt.videometrics.login.UserInformation;

import android.content.Context;

public class StorageUtils {
	private static final StorageUtils INSTANCE = new StorageUtils();
	private StorageUtils(){}
	
	public static StorageUtils getInstance(){
		return INSTANCE;
	}
	
	public void writeUserCredit(Context context, JSONObject userCredit){
		try{
			File file = new File(context.getFilesDir(), "usercredit");
			if(file.exists() == false){
				file.createNewFile();
			}
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(userCredit.toString().getBytes());
			outStream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public UserInformation getUserCredit(Context context){
		UserInformation resultObj = null;
		try{
			File file = new File(context.getFilesDir(), "usercredit");
			if(file.exists() == false){
				return null;
			}
			
			FileInputStream inputStream = new FileInputStream(file);
			String szUserCredit = StringUtils.ConvertStreamToString(inputStream);
			JSONObject jsonUserCreadit = new JSONObject(szUserCredit);
			
			String szUsername = jsonUserCreadit.getString("username");
			String szPassword = jsonUserCreadit.getString("password");
			
			resultObj = new UserInformation(szUsername, szPassword);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return resultObj;
	}
}
