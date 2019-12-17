package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Hardware;
import com.websystique.springmvc.service.UserService;


public interface HardwareProfileDao {

	List<Hardware> findAllh();
	
	
	Hardware findByTypeh(String id);
	
	Hardware findByIdh(int id);
}
