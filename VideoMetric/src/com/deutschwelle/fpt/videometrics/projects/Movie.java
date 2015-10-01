package com.deutschwelle.fpt.videometrics.projects;

public class Movie {
	private int mMovieId;
	private String mMovieTitle = "";
	private String mMovieDescription = "";
	private String mMovieUrl = "";
	private String mMovieThumbUrl = ""; 
	
	public Movie(int movieId, String szMovieTitle, String szMovieDes, String szMovieUrl, String szMovieThumb){
		this.mMovieId = movieId;
		this.mMovieTitle = szMovieTitle;
		this.mMovieDescription = szMovieDes;
		this.mMovieUrl = szMovieUrl;
		this.mMovieThumbUrl = szMovieThumb;
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
	
	
}
