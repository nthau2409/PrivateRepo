package com.deutschwelle.fpt.videometrics.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
	public static boolean verifyNetwork(Context context){
		
		boolean networkAvailable = false;
		
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo[] netInfo = cm.getAllNetworkInfo();
	    for (NetworkInfo ni : netInfo) {
	        if (ni.getTypeName().equalsIgnoreCase("WIFI")){
	        	if (ni.isConnected()){
	        		networkAvailable = true;
	        	}
	        }
	        if (ni.getTypeName().equalsIgnoreCase("MOBILE")){
	        	if (ni.isConnected()){
	        		networkAvailable = true;
	        	}
	        }
	                
	    }
	    
	    return networkAvailable;
	}
}
