package com.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.dao.CountryDao;
import com.entity.Country;
import com.service.CountryService;
@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	private CountryDao countryDao;
	@Autowired
	private void setCountryDao(CountryDao countryDao){
		this.countryDao = countryDao;
	}

	@Override
	public void saveOrUpdate(Country c) {
		countryDao.saveOrUpdate(c);

	}

	@Override
	public List<Country> get() {
		return countryDao.get();
	}

	@Override
	public Country findById(int id) {
		return countryDao.findById(id);
	}

	@Override
	public void delete(int id) {
		countryDao.delete(id);
	}

}
