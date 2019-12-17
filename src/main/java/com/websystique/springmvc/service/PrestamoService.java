package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Prestamo;


public interface PrestamoService {
	
	Prestamo findByIdp(int id);
	
	Prestamo findByPRES(String pres);
	
	void savePrestamo(Prestamo prestamo);
	
	void updatePrestamo(Prestamo prestamo);
	
	void deletePrestamoByPRES(String pres);

	List<Prestamo> findAllPrestamos(); 
	
	boolean isPrestamoPRESUnique(Integer id, String pres);

}