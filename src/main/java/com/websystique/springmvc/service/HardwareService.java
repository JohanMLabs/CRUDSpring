package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Hardware;


public interface HardwareService {
	
	Hardware findByIdh(int id);
	
	Hardware findByHARD(String hard);
	
	void saveHardware(Hardware hardware);
	
	void updateHardware(Hardware hardware);
	
	void deleteHardwareByHARD(String hard);

	List<Hardware> findAllhardwares(); 
	
	boolean isHardwareHARDUnique(Integer id, String hard);

}