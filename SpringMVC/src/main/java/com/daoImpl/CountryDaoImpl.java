package com.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CountryDao;
import com.entity.Country;
@Repository
public class CountryDaoImpl implements CountryDao {
	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFctory;
	private Session getSession(){
		return sessionFctory.getCurrentSession();
	}

	@Override
	public void saveOrUpdate(Country c) {
		getSession().saveOrUpdate(c);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> get() {
		Criteria criteria = getSession().createCriteria(Country.class);
		return (List<Country>)criteria.list();
	}

	@Override
	public Country findById(int id) {
		Country country = (Country) getSession().get(Country.class, id);
		return country;
	}

	@Override
	public void delete(int id) {
		Country country = (Country) getSession().get(Country.class, id);
		getSession().delete(country);

	}

}
