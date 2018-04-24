package com.training.basics1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	List<String> names = new ArrayList<>();

	/**
	 * 
	 * Historically, the two approaches come from different versions of Spring.
	 * The ModelAndView approach was the primary way of returning both model and
	 * view information from a controller in pre-Spring 2.0. Now you can combine
	 * the Model parameter and the String return value, but the old approach is
	 * still valid.
	 * 
	 */
	
	/**
	 * 
	 * The /index endpoint is to be called first
	 * This endpoint will set the view to index.html
	 * 
	 * From the index.html, a form is submitted which will hit
	 * the /add endpoint and take 'name' as a request parameter
	 * and will set the view to added.html
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		modelAndView.addObject("names", names);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam String name, ModelAndView modelAndView) {
		if (null != name) {
			names.add(name);
		}
		modelAndView.addObject("name", name);
		modelAndView.setViewName("added");
		return modelAndView;
	}

	/**
	 * 
	 * The /index1 endpoint is to be called first
	 * This endpoint will set the view to index1.html same as the above
	 * but will not use model and view, but will instead use only model
	 * 
	 * From the index.html, a form is submitted which will hit
	 * the /add endpoint and take 'name' as a request parameter
	 * and will set the view to added1.html
	 * 
	 */
	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public String index1(Model model) {
		model.addAttribute("names", names);
		return "index1";
	}

	@RequestMapping(value = "/add1", method = RequestMethod.GET)
	public String add1(@RequestParam String name, Model model) {
		if (null != name) {
			names.add(name);
		}
		model.addAttribute("name", name);
		return "added";
	}

}
