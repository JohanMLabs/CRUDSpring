package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.HardwareProfileDao;
import com.websystique.springmvc.model.Hardware;


@Service("hardwareProfileService")
@Transactional
public class HardwareProfileServiceImpl implements HardwareProfileService{
	
	@Autowired
	HardwareProfileDao dao;
	
	public Hardware findByIdh(int id) {
		return dao.findByIdh(id);
	}

	public Hardware findByTypeh(String id){
		return dao.findByTypeh(id);
	}

	public List<Hardware> findAllh() {
		return dao.findAllh();
	}
     
}
