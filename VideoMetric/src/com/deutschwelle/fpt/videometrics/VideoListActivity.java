package com.deutschwelle.fpt.videometrics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class VideoListActivity extends Activity{
	private static final String TAG = "[" + VideoListActivity.class.getSimpleName() + "]";
	
	private ImageButton mLeftBtn = null;
	private ImageButton mRightBtn = null;
	private ImageView mPlayBtn = null;
	private ViewPager mViewPager = null;
	private ImageView mLogoutBtn = null;
	
	public static interface OnPostExecuteListener{
		void onPreExecute();
        void onPostExecute();
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_video_list);
	    
	    mLeftBtn = (ImageButton) findViewById(R.id.btn_left);
	    mRightBtn = (ImageButton) findViewById(R.id.btn_right);
	    mPlayBtn = (ImageView) findViewById(R.id.btn_play_video);
	    mLogoutBtn = (ImageView) findViewById(R.id.btn_logout);
	    mViewPager = (ViewPager) findViewById(R.id.view_pager);
	    
	    mLeftBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int nCurrentIndex = mViewPager.getCurrentItem();
				if(nCurrentIndex > 0){
					mViewPager.setCurrentItem(nCurrentIndex - 1);
				}
			}
		});
	    
	    mRightBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int nCurrentIndex = mViewPager.getCurrentItem();
				int nItemCount = mViewPager.getChildCount();
				if(nCurrentIndex < nItemCount - 1){
					mViewPager.setCurrentItem(nCurrentIndex + 1);
				}
			}
		});
	    
	    mLogoutBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(VideoListActivity.this, HomeActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	    
	    VideoAdapter adapter = new VideoAdapter(this);
	    mViewPager.setAdapter(adapter);
	    
	    mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
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
