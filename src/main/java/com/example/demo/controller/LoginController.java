package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("")
	public String loginView() {
		return "entry/login-view";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "user-view/user-home";
	}

}
