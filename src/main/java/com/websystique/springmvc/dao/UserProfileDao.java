package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
