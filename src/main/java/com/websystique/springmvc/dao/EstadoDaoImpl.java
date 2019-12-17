package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Estado;



@Repository("estadoDao")
public class EstadoDaoImpl extends AbstractDao<Integer, Estado> implements EstadoDao {

	static final Logger logger = LoggerFactory.getLogger(EstadoDaoImpl.class);
	
	public Estado findByIde(int id) {
		Estado estado = getByKey(id);
		if(estado!=null){
			Hibernate.initialize(estado.getId());
		}
		return estado;
	}

	public Estado findByEST(String est) {
		logger.info("est : {}", est);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("estadoId", est));
		Estado estado = (Estado)crit.uniqueResult();
		if(estado!=null){
			Hibernate.initialize(estado.getId());
		}
		return estado;
	}

	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstados() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("estadoId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Estado> estados = (List<Estado>) criteria.list();
		
		
		return estados;
	}

	public void savee(Estado estado) {
		persist(estado);
	}

	public void deleteByEST(String est) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("estadoId", est));
		Estado estado = (Estado)crit.uniqueResult();
		delete(estado);
	}

    

}
