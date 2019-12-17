package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Hardware;


public interface HardwareProfileService {

	Hardware findByIdh(int id);

	Hardware findByTypeh(String id);
	
	List<Hardware> findAllh();
   
	
}
