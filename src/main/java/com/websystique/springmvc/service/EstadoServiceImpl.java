package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.EstadoDao;
import com.websystique.springmvc.model.Estado;


@Service("estadoService")
@Transactional
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoDao dao;

//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	public Estado findByIde(int id) {
		return dao.findByIde(id);
	}

	public Estado findByEST(String est) {
		Estado estado = dao.findByEST(est);
		return estado;
	}

	public void saveEstado(Estado estado) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.savee(estado);
	}

	
	public void updateEstado(Estado estado) {
		Estado entity = dao.findByIde(estado.getId());
		if(entity!=null){
			entity.setEstadoId(estado.getEstadoId());
			
			entity.setNombreEstado(estado.getNombreEstado());
			
		}
	}

	
	

	public List<Estado> findAllEstados() {
		return dao.findAllEstados();
	}

	public boolean isEstadoESTUnique(Integer id, String est) {
		Estado estado = findByEST(est);
		return ( estado == null || ((id != null) && (estado.getId() == id)));
	}

    @Override
    public void deleteEstadoByEST(String est) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       dao.deleteByEST(est);
    }
	
}
