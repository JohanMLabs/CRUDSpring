package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.HardwareDao;
import com.websystique.springmvc.model.Hardware;


@Service("hardwareService")
@Transactional
public class HardwareServiceImpl implements HardwareService{

	@Autowired
	private HardwareDao dao;

//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	public Hardware findByIdh(int id) {
		return dao.findByIdh(id);
	}

	public Hardware findByHARD(String hard) {
		Hardware hardware = dao.findByHARD(hard);
		return hardware;
	}

	public void saveHardware(Hardware hardware) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.saveh(hardware);
	}

	
	public void updateHardware(Hardware hardware) {
		Hardware entity = dao.findByIdh(hardware.getId());
		if(entity!=null){
			entity.setHardwareId(hardware.getHardwareId());
			entity.setDescripcion(hardware.getDescripcion());
			entity.setObservacion(hardware.getObservacion());
			entity.setEstadoId(hardware.getEstadoId());
			entity.setEstadoObjeto(hardware.getEstadoObjeto());
			entity.setPrestamoId(hardware.getPrestamoId());
			entity.setMarca(hardware.getMarca());
			entity.setModelo(hardware.getModelo());
			entity.setAsignacionId(hardware.getAsignacionId());
			entity.setFechaCreado(hardware.getFechaCreado());
			entity.setFechaModificado(hardware.getFechaModificado());
			entity.setUserId(hardware.getUserId());
			entity.setBodegaId(hardware.getBodegaId());
			
		}
	}

	
	

	public List<Hardware> findAllhardwares() {
		return dao.findAllhardwares();
	}

	public boolean isHardwareHARDUnique(Integer id, String hard) {
		Hardware hardware = findByHARD(hard);
		return ( hardware == null || ((id != null) && (hardware.getId() == id)));
	}

    @Override
    public void deleteHardwareByHARD(String hard) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       dao.deleteByHARD(hard);
    }
	
}
