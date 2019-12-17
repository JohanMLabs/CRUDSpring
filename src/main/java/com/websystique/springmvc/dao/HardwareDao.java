
package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Hardware;


public interface HardwareDao {

	Hardware findByIdh(int id);
	
	Hardware findByHARD(String hard);
	
	void saveh(Hardware hardware);
	
	void deleteByHARD(String hard);
	
	List<Hardware> findAllhardwares();
        
//        Hardware getHardwareByIdWithNamedQuery(Long id);
        

}