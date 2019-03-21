package com.project.dao;

import java.util.List;

import com.project.model.Resource;

public interface ResourceDao {

	List<Resource> queryResource();

	int insertResource(Resource res);

	void deleteResource(String pptName);

	void updateResource(Resource res);

	Resource findResource(String pptName);

	List<Resource> queryResource11(String faculty);
}