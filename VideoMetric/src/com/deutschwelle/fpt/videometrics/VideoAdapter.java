package com.deutschwelle.fpt.videometrics;

import com.deutschwelle.fpt.videometrics.projects.Project;
import com.deutschwelle.fpt.videometrics.projects.ProjectsManager;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class VideoAdapter extends PagerAdapter {
	private Context context;
	
    VideoAdapter(Context context){
    	this.context=context;
    }
    @Override
    public int getCount() {
    	return ProjectsManager.getInstance().getProjectCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
    	return view == ((VideoView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	VideoView videoView = new VideoView(context);
    	
    	Project project = ProjectsManager.getInstance().getProject(position);
    	Uri uri = Uri.parse(project.getMovie().getMovieUrl());
    	videoView.setVideoURI(uri);
    	videoView.setVisibility(View.VISIBLE);
    	videoView.requestFocus();
    	
    	((ViewPager)container).addView(videoView, 0);
    	videoView.start();
    	
    	return videoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	((ViewPager) container).removeView((VideoView) object);
    }
}
