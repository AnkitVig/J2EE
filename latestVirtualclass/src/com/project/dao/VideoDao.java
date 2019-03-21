package com.project.dao;

import java.util.List;

import com.project.model.Video;

public interface VideoDao {

	
	Video findVideo(String videoName);

	void updateVideo(Video video);

	void deleteVideo(String videoName);

	int insertVideo(Video Video);

	List<Video> queryVideo();

	List<Video> queryVideo11(String userName);
}