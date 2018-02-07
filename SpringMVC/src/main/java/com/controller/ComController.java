package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entity.Country;
import com.service.CountryService;


@Controller
@RequestMapping(value= {"/country"})
public class ComController {
	@Autowired
	private CountryService countryService; 
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView getPage() {
		
		ModelAndView view = new ModelAndView("country");
		List<Country> list = countryService.get();
		view.addObject("list", list);
		return view;
	}
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new  ModelAndView("addcountry");
		Country country = new Country();
		model.addObject("country", country);
		return model;
	}
	@RequestMapping(value="/update/{countryId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("countryId") int countryId){
		ModelAndView model = new  ModelAndView("addcountry");
		Country country = countryService.findById(countryId);
		model.addObject("country", country);
		return model;
		
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("country") Country country){
		countryService.saveOrUpdate(country);
		return new ModelAndView("redirect:/country/list");
	}
	@RequestMapping(value="/country/delete/{countryId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("countryId") int countryId){
		
		countryService.delete(countryId);
		
		return new ModelAndView("redirect:/country/list");
		
	}

}
