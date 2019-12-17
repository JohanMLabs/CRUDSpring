package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Estado;


public interface EstadoService {
	
	Estado findByIde(int id);
	
	Estado findByEST(String est);
	
	void saveEstado(Estado estado);
	
	void updateEstado(Estado estado);
	
	void deleteEstadoByEST(String est);

	List<Estado> findAllEstados(); 
	
	boolean isEstadoESTUnique(Integer id, String est);

}