package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AsignacionDao;
import com.websystique.springmvc.model.Asignacion;


@Service("asignacionService")
@Transactional
public class AsignacionServiceImpl implements AsignacionService{

	@Autowired
	private AsignacionDao dao;

	//@Autowired
    //private PasswordEncoder passwordEncoder;
	
	public Asignacion findByIda(int id) {
		return dao.findByIda(id);
	}

	public Asignacion findByASI(String asi) {
		Asignacion asignacion = dao.findByASI(asi);
		return asignacion;
	}

	public void saveAsignacion(Asignacion asignacion) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.savea(asignacion);
	}

	
	public void updateAsignacion(Asignacion asignacion) {
		Asignacion entity = dao.findByIda(asignacion.getId());
		if(entity!=null){
			entity.setAsignacionId(asignacion.getAsignacionId());
			
			entity.setUsuarioFk(asignacion.getUsuarioFk());
			entity.setFechaCreado(asignacion.getFechaCreado());
			entity.setFechaModificado(asignacion.getFechaModificado());
			entity.setHardwareFk(asignacion.getHardwareFk());
			
		}
	}

	
	public void deleteAsignacionByASI(String asi) {
		dao.deleteByASI(asi);
	}

	public List<Asignacion> findAllAsignaciones() {
		return dao.findAllAsignaciones();
	}

	public boolean isAsignacionASIUnique(Integer id, String asi) {
		Asignacion asignacion = findByASI(asi);
		return ( asignacion == null || ((id != null) && (asignacion.getId() == id)));
	}
	
}
