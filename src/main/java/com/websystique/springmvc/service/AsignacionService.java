package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Asignacion;

public interface AsignacionService {
	
	Asignacion findByIda(int id);
	
	Asignacion findByASI(String asi);
	
	void saveAsignacion(Asignacion asignacion);
	
	void updateAsignacion(Asignacion asignacion);
	
	void deleteAsignacionByASI(String asi);

	List<Asignacion> findAllAsignaciones(); 
	
	boolean isAsignacionASIUnique(Integer id, String asi);

}