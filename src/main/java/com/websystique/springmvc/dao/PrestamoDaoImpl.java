package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Prestamo;



@Repository("prestamoDao")
public class PrestamoDaoImpl extends AbstractDao<Integer, Prestamo> implements PrestamoDao {

	static final Logger logger = LoggerFactory.getLogger(PrestamoDaoImpl.class);
	
	public Prestamo findByIdp(int id) {
		Prestamo prestamo = getByKey(id);
		if(prestamo!=null){
			Hibernate.initialize(prestamo.getId());
		}
		return prestamo;
	}

	public Prestamo findByPRES(String pres) {
		logger.info("PRES : {}", pres);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("prestamoId", pres));
		Prestamo prestamo = (Prestamo)crit.uniqueResult();
		if(prestamo!=null){
			Hibernate.initialize(prestamo.getId());
		}
		return prestamo;
	}

	@SuppressWarnings("unchecked")
	public List<Prestamo> findAllPrestamos() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("prestamoId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Prestamo> prestamos = (List<Prestamo>) criteria.list();
		
		
		return prestamos;
	}

	public void savep(Prestamo prestamo) {
		persist(prestamo);
	}

	public void deleteByPRES(String pres) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("prestamoId", pres));
		Prestamo prestamo = (Prestamo)crit.uniqueResult();
		delete(prestamo);
	}

    

}
