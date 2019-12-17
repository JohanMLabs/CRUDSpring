package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Hardware;
import org.springframework.data.jdbc.repository.query.Query;



@Repository("hardwareDao")
public class HardwareDaoImpl extends AbstractDao<Integer, Hardware> implements HardwareDao {

	static final Logger logger = LoggerFactory.getLogger(HardwareDaoImpl.class);
	
	public Hardware findByIdh(int id) {
		Hardware hardware = getByKey(id);
		if(hardware!=null){
			Hibernate.initialize(hardware.getId());
		}
		return hardware;
	}

	public Hardware findByHARD(String hard) {
		logger.info("HARD : {}", hard);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("hardwareId", hard));
		Hardware hardware = (Hardware)crit.uniqueResult();
		if(hardware!=null){
			Hibernate.initialize(hardware.getId());
		}
		return hardware;
	}

	@SuppressWarnings("unchecked")
	public List<Hardware> findAllhardwares() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("hardwareId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Hardware> hardwares = (List<Hardware>) criteria.list();
		
		
		return hardwares;
	}

	public void saveh(Hardware hardware) {
		persist(hardware);
	}

	public void deleteByHARD(String hard) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("hardwareId", hard));
		Hardware hardware = (Hardware)crit.uniqueResult();
		delete(hardware);
        }
        

//        public Hardware getHardwareByIdWithNamedQuery(Long id) {
//    Query namedQuery;
//            namedQuery = getEntityManager().createNamedQuery("Hardware.findByIdg");
//    namedQuery.setParameter("hardwareId", id);
//    return (Hardware) namedQuery.getSingleResult();
//}
  
}