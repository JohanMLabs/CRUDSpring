package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Asignacion;


public interface AsignacionDao {

	Asignacion findByIda(int id);
	
	Asignacion findByASI(String asi);
	
	void savea(Asignacion asignacion);
	
	void deleteByASI(String ASI);
	
	List<Asignacion> findAllAsignaciones();

}

