package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PrestamoDao;
import com.websystique.springmvc.model.Prestamo;


@Service("prestamoService")
@Transactional
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	private PrestamoDao dao;

//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	public Prestamo findByIdp(int id) {
		return dao.findByIdp(id);
	}

	public Prestamo findByPRES(String pres) {
		Prestamo prestamo = dao.findByPRES(pres);
		return prestamo;
	}

	public void savePrestamo(Prestamo prestamo) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.savep(prestamo);
	}

	
	public void updatePrestamo(Prestamo prestamo) {
		Prestamo entity = dao.findByIdp(prestamo.getId());
		if(entity!=null){
			entity.setPrestamoId(prestamo.getPrestamoId());
			
			entity.setUsuario(prestamo.getUsuario());
			entity.setEstado(prestamo.getEstado());
			entity.setFechaCreado(prestamo.getFechaCreado());
			entity.setFechaModificado(prestamo.getFechaModificado());
			//entity.setCorreo(user.getCorreo());
			//entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	

	public List<Prestamo> findAllPrestamos() {
		return dao.findAllPrestamos();
	}

	public boolean isPrestamoPRESUnique(Integer id, String pres) {
		Prestamo prestamo = findByPRES(pres);
		return ( prestamo == null || ((id != null) && (prestamo.getId() == id)));
	}

    @Override
    public void deletePrestamoByPRES(String pres) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       dao.deleteByPRES(pres);
    }
	
}
