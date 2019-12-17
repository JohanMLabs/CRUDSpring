package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Asignacion;



@Repository("asignacionDao")
public class AsignacionDaoImpl extends AbstractDao<Integer, Asignacion> implements AsignacionDao {

	static final Logger logger = LoggerFactory.getLogger(AsignacionDaoImpl.class);
	
	public Asignacion findByIda(int id) {
		Asignacion asignacion = getByKey(id);
		if(asignacion!=null){
			Hibernate.initialize(asignacion.getId());
		}
		return asignacion;
	}

	public Asignacion findByASI(String asi) {
		logger.info("ASI : {}", asi);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("asignacionId", asi));
		Asignacion asignacion = (Asignacion)crit.uniqueResult();
		if(asignacion!=null){
			Hibernate.initialize(asignacion.getId());
		}
		return asignacion;
	}

	@SuppressWarnings("unchecked")
	public List<Asignacion> findAllAsignaciones() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("asignacionId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Asignacion> asignacion = (List<Asignacion>) criteria.list();
		
		
		return asignacion;
	}

	public void savea(Asignacion asignacion) {
		persist(asignacion);
	}

	public void deleteByASI(String asi) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("asignacionId", asi));
		Asignacion asignacion = (Asignacion)crit.uniqueResult();
		delete(asignacion);
	}

    

}
