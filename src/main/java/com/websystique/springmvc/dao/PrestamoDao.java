package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Prestamo;


public interface PrestamoDao {

	Prestamo findByIdp(int id);
	
	Prestamo findByPRES(String pres);
	
	void savep(Prestamo prestamo);
	
	void deleteByPRES(String pres);
	
	List<Prestamo> findAllPrestamos();

}

