package com.deutschwelle.fpt.videometrics;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.VideoView;

public class VideoListActivity extends Activity{

	private static final String TAG = "[" + VideoListActivity.class.getSimpleName() + "]";
	
	public static interface OnPostExecuteListener{
		void onPreExecute();
        void onPostExecute();
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_video_list);
	    
	    final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
	    VideoAdapter adapter = new VideoAdapter(this);
	    viewPager.setAdapter(adapter);
	    
	    viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pageIndex) {
				//VideoView video = (VideoView) viewPager.getChildAt(pageIndex);
				//Log.i(TAG, "[onPageSelected] pageIndex = " + pageIndex + ", video = " + video.getClass().getName());
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int pageIndex) {
			}
		});
	}
}
