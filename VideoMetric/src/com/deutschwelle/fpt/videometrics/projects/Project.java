package com.deutschwelle.fpt.videometrics.projects;

public class Project {
	private int mProjectId;
	private int mGroupId;
	private String mGroupName = "";
	private String mProjectName = "";
	
	private Movie mMovie = null;

	public Project(int projectId, int groupId, String groupName, String projectName, Movie movie){
		this.mProjectId = projectId;
		this.mGroupId = groupId;
		this.mGroupName = groupName;
		this.mProjectName = projectName;
		this.mMovie = movie;
	}
	
	public int getProjectId() {
		return mProjectId;
	}

	public void setProjectId(int projectId) {
		this.mProjectId = projectId;
	}

	public int getGroupId() {
		return mGroupId;
	}

	public void setGroupId(int groupId) {
		this.mGroupId = groupId;
	}

	public String getGroupName() {
		return mGroupName;
	}

	public void setGroupName(String groupName) {
		this.mGroupName = groupName;
	}

	public String getProjectName() {
		return mProjectName;
	}

	public void setProjectName(String projectName) {
		this.mProjectName = projectName;
	}

	public Movie getMovie() {
		return mMovie;
	}

	public void setMovie(Movie movie) {
		this.mMovie = movie;
	}
}
