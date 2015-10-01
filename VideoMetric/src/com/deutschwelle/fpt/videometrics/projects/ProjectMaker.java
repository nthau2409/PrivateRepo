package com.deutschwelle.fpt.videometrics.projects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProjectMaker {
	
	private static final String PROJECT_ID		= "projectId";
	private static final String GROUP_ID		= "groupId";
	private static final String GROUP_NAME		= "groupName";
	private static final String PROJECT_NAME	= "projectName";
	private static final String MOVIE			= "movie";
	
	private static final String MOVIE_ID		= "movieId";
	private static final String MOVIE_TITLE		= "movieTitle";
	private static final String MOVIE_DESC		= "movieDescription";
	private static final String MOVIE_URL		= "movieUrl";
	private static final String MOVIE_THUMB		= "movieThumbUrl";
	
	
	private JSONArray mjsonArray = null;
	
	public ProjectMaker(JSONArray jsonArray){
		mjsonArray = jsonArray;
	}
	
	public void process(){
		int nJsonObjCount = mjsonArray.length();
		for(int nObjIndex = 0; nObjIndex < nJsonObjCount; nObjIndex++){
			JSONObject obj = null;
			try {
				obj = mjsonArray.getJSONObject(nObjIndex);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			Project project = makeProject(obj);
			if(project != null){
				ProjectsManager.getInstance().addProject(project);
			}
		}
	}
	
	private Project makeProject(JSONObject jsonObj){
		try {
			String szProjectId = jsonObj.getString(PROJECT_ID);
			String szGroupId = jsonObj.getString(GROUP_ID);
			String szGroupName = jsonObj.getString(GROUP_NAME);
			String szProjectName = jsonObj.getString(PROJECT_NAME);
			
			JSONObject movieObj = jsonObj.getJSONObject(MOVIE);
			String szMovieId = movieObj.getString(MOVIE_ID);
			String szMovieTitle = movieObj.getString(MOVIE_TITLE);
			String szMovieDesc = movieObj.getString(MOVIE_DESC);
			String szMovieUrl = movieObj.getString(MOVIE_URL);
			String szMovieThumb = movieObj.getString(MOVIE_THUMB);
			
			Movie movie = new Movie(Integer.valueOf(szMovieId), szMovieTitle, szMovieDesc, szMovieUrl, szMovieThumb);
			
			return new Project(Integer.valueOf(szProjectId), Integer.valueOf(szGroupId), szGroupName, szProjectName, movie);
			
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
