package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Estado;


public interface EstadoDao {

	Estado findByIde(int id);
	
	Estado findByEST(String est);
	
	void savee(Estado estado);
	
	void deleteByEST(String est);
	
	List<Estado> findAllEstados();

}

