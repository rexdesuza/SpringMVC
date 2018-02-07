package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Country;
import com.service.CountryService;

@Controller
@RequestMapping(value="/ajax")
public class AJAXController {
	
	CountryService service;

	@Autowired
	public void setService(CountryService service) {
		this.service = service;
	}
	@RequestMapping(value="/page")
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("countryAJAX");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(Country country){
		Map<String, Object> map = new HashMap<>();
		if(country != null){
			service.saveOrUpdate(country);
			map.put("status", 200);
			map.put("message", "your record has been saved successfully!!");
		}
		return map;
	}
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Country country){
		Map<String, Object> map = new HashMap<>();
		List<Country> list = service.get();
		if(list != null){
			map.put("status", 200);
			map.put("message", "data found");
			map.put("data", list);
		}else{
			map.put("status", 404);
			map.put("message", "data not found");
		}
		return map;
		
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Country country){
		Map<String, Object> map = new HashMap<>();
		if(country != null){
			service.delete(country.getCountryId());
			map.put("status", 200);
			map.put("message", "your record has been deleted successfully!!");
		}
		return map;
	}

	
	
}
