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

	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public String index1(Model model) {
		model.addAttribute("names", names);
		return "index";
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
