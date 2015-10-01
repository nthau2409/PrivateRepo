package com.deutschwelle.fpt.videometrics.projects;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Movie {
	private int mMovieId;
	private String mMovieTitle = "";
	private String mMovieDescription = "";
	private String mMovieUrl = "";
	private String mMovieThumbUrl = ""; 
	private Bitmap mBitmap = null;
	
	public Movie(int movieId, String szMovieTitle, String szMovieDes, String szMovieUrl, String szMovieThumb){
		this.mMovieId = movieId;
		this.mMovieTitle = szMovieTitle;
		this.mMovieDescription = szMovieDes;
		this.mMovieUrl = szMovieUrl;
		this.mMovieThumbUrl = szMovieThumb;
		
		mBitmap = getBitmapFromURL(szMovieThumb);
	}
	
	public int getMovieId() {
		return mMovieId;
	}
	public void setMovieId(int mMovieId) {
		this.mMovieId = mMovieId;
	}
	public String getMovieTitle() {
		return mMovieTitle;
	}
	public void setMovieTitle(String mMovieTitle) {
		this.mMovieTitle = mMovieTitle;
	}
	public String getMovieDescription() {
		return mMovieDescription;
	}
	public void setMovieDescription(String mMovieDescription) {
		this.mMovieDescription = mMovieDescription;
	}
	public String getMovieUrl() {
		return mMovieUrl;
	}
	public void setMovieUrl(String mMovieUrl) {
		this.mMovieUrl = mMovieUrl;
	}
	public String getMovieThumbUrl() {
		return mMovieThumbUrl;
	}
	public void setMovieThumbUrl(String mMovieThumbUrl) {
		this.mMovieThumbUrl = mMovieThumbUrl;
	}
	
	public Bitmap getMovieThumbnailBitmap(){
		return mBitmap;
	}
	
	private Bitmap getBitmapFromURL(String imageUrl) {
		Bitmap bitmap = null;
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setInstanceFollowRedirects(true);
            InputStream input = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bitmap;
	}
}
