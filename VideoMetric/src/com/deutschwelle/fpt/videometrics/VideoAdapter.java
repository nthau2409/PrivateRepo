package com.deutschwelle.fpt.videometrics;

import java.util.ArrayList;
import java.util.List;

import com.deutschwelle.fpt.videometrics.projects.Project;
import com.deutschwelle.fpt.videometrics.projects.ProjectsManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.VideoView;

public class VideoAdapter extends PagerAdapter {
	private Context context;
	private List<VideoView> videos = new ArrayList<VideoView>();
	
    VideoAdapter(Context context){
    	this.context=context;
    }
    @Override
    public int getCount() {
    	return ProjectsManager.getInstance().getProjectCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
    	return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	Project project = ProjectsManager.getInstance().getProject(position);
//    	VideoView videoView = new VideoView(context);
//    	Uri uri = Uri.parse(project.getMovie().getMovieUrl());
//    	videoView.setVideoURI(uri);
//    	videoView.setVisibility(View.VISIBLE);
//    	videoView.requestFocus();
//    	videoView.start();
    	
    	ImageView imageView = new ImageView(context);
    	Bitmap bitmap = project.getMovie().getMovieThumbnailBitmap();
//    	Uri imageUri = Uri.parse(project.getMovie().getMovieThumbUrl());
//    	
//    	imageView.setImageURI(imageUri);
//    	imageView.setScaleType(ScaleType.FIT_XY);
    	imageView.setImageBitmap(bitmap);
    	((ViewPager)container).addView(imageView, 0);
    	
    	return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	((ViewPager) container).removeView((ImageView) object);
    }
}
