package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Hardware;
import com.websystique.springmvc.service.HardwareService;



@Repository("hardwareProfileDao")
public class HardwareProfileDaoImpl extends AbstractDao<Integer, Hardware>implements HardwareProfileDao{

	public Hardware findByIdh(int id) {
		return getByKey(id);
	}

	public Hardware findByTypeh(String id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		return (Hardware) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Hardware> findAllh(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("id"));
		return (List<Hardware>)crit.list();
	}
	
}
