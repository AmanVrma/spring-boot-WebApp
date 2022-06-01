package com.springBoot.springbootWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springBoot.springbootWebApp.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	//Model
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginmsg(ModelMap model) {
		//model.put("name", name);
		return "login";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String ShowWelcome(@RequestParam String name ,ModelMap model, @RequestParam String password) {
		boolean isvalid = service.validateuser(name,password);
		if(!isvalid) {
			model.put("message","Invalid userId or password!!!!!");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
	
}
