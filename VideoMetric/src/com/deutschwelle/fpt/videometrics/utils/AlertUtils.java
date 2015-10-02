package com.deutschwelle.fpt.videometrics.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class AlertUtils {
	public static void showAlertDialog(Context context, String szMessageTitle, String szMessageContent){
//		new AlertDialog.Builder(context)
//	    .setTitle(szMessageTitle)
//	    .setMessage(szMessageContent)
//	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int which) { 
//	            // continue with delete
//	        }
//	     })
//	    .setIcon(android.R.drawable.ic_dialog_alert)
//	    .show();
		
		
		new AlertDialog.Builder(context)
        .setTitle(szMessageTitle)
        .setMessage(szMessageContent)
        .setCancelable(false)
        .setPositiveButton("ok", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // whatever...                        
            }
        }).create().show();        
	}
}
