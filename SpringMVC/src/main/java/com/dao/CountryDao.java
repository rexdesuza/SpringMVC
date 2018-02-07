package com.dao;

import java.util.List;

import com.entity.Country;



public interface CountryDao {
	
	public void saveOrUpdate(Country c);
	public List<Country> get();
	public Country findById(int id);
	public void delete(int id);


}
