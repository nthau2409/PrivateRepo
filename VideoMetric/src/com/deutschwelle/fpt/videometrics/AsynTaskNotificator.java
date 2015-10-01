package com.deutschwelle.fpt.videometrics;

public interface AsynTaskNotificator {
	void onPreExecute();
	
    void onPostExecute(int nResult);
}
