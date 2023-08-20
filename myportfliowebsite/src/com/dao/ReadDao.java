package com.dao;

import java.util.ArrayList;


import com.pojo.LoginDetails;
import com.pojo.Project;

public interface ReadDao {
	public ArrayList<com.pojo.Message> readAllMessage();
	public String login(String userId, String password);
	public LoginDetails getLoginDetails();
	public ArrayList<Project> getProjectDetails();
}
