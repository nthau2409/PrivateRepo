package com.deutschwelle.fpt.videometrics;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import com.deutschwelle.fpt.videometrics.login.UserInformation;
import com.deutschwelle.fpt.videometrics.tasks.LoginTask;
import com.deutschwelle.fpt.videometrics.utils.Storage;

public class HomeActivity extends Activity {
	private static final int DIALOG_LOADING = 1;	
	private EditText mEdtUsername = null;
	private EditText mEdtPassword = null;
	private ImageButton mImgBtnLogin = null;
	private AsynTaskNotificator mNotificator = null;
	
	public String loginMessage = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        
        // initialize views
        mEdtUsername = (EditText)findViewById(R.id.edit_user_name);
        mEdtPassword = (EditText)findViewById(R.id.edit_password);
        mImgBtnLogin = (ImageButton)findViewById(R.id.img_btn_login);
        mImgBtnLogin.setBackgroundResource(R.drawable.btn_login_backgroud_change);
        
        // username: api@a.b
        // password: !23Test
        
        UserInformation savedUserInfo = Storage.getInstance().getUserCredit(getApplicationContext());
        if (savedUserInfo != null) {
			mEdtUsername.setText(savedUserInfo.getUserName());
			mEdtPassword.setText(savedUserInfo.getPassword());
		}
        
        mNotificator = new AsynTaskNotificator() {
			
			@Override
			public void onPreExecute() {
				showDialog(DIALOG_LOADING);
			}
			
			@Override
			public void onPostExecute(int nResult) {
				dismissDialog(DIALOG_LOADING);
				if(nResult == HttpStatus.SC_OK){
					
					// save username and password.
					JSONObject userCredit = new JSONObject();
					try {
						userCredit.put("username", mEdtUsername.getEditableText().toString());
						userCredit.put("password", mEdtPassword.getEditableText().toString());
						
						Storage.getInstance().writeUserCredit(getApplicationContext(), userCredit);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
					Intent intent = new Intent(HomeActivity.this, VideoListActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
				}
			}
		};

        mImgBtnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				String szUserName = mEdtUsername.getEditableText().toString();
				String szPassword = mEdtPassword.getEditableText().toString();
				UserInformation userInfo = new UserInformation(szUserName, szPassword);
				
				LoginTask loginTask = new LoginTask(mNotificator);
				try {
					loginTask.execute(userInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  
			}
		});
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DIALOG_LOADING:
            final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //here we set layout of progress dialog
            dialog.setContentView(R.layout.custom_progress_dialog);
            dialog.setCancelable(true);            
        return dialog;  
 
        default:
            return null;
        }
    };
    
}
