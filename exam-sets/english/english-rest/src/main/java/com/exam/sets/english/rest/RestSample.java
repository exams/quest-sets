package com.exam.sets.english.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/rest")
public class RestSample {

	@RequestMapping(value="/get", method=RequestMethod.GET)
	public void getRestInfo(Model model){
		
		model.addAttribute("getInfo");
	}
	
	
}
