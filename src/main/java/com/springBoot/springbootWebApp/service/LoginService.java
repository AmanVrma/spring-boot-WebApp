package com.springBoot.springbootWebApp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateuser(String userid, String password) {

		return userid.equalsIgnoreCase("robot") && password.equalsIgnoreCase("blah");
	}
}
