package com.project.dao;

import java.util.List;

import com.project.model.UserAccount;

public interface UserAccountDao {

	UserAccount findUser(String userName, String password);

	UserAccount checkDetail(String userName);

	UserAccount findUser(String userName);

	List<UserAccount> queryUser();

	void deleteVideo(String userName);

	int insertUser(UserAccount user);

}
