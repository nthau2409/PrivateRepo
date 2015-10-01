package com.deutschwelle.fpt.videometrics.projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
	private static final ProjectsManager instance = new ProjectsManager();
	private List<Project> projects = new ArrayList<Project>();
	
	private ProjectsManager(){
		
	}
	
	public static ProjectsManager getInstance(){
		return instance;
	}
	
	public void addProject(Project project){
		projects.add(project);
	}
	
	public Project getProject(int index){
		return projects.get(index);
	}
	
	public int getProjectCount(){
		return projects.size();
	}
}
