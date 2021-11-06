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
	
	@RequestMapping("/home")
	public String test() {
		return "user-view/home";
	}
	
	@RequestMapping("/transfer")
	public String transfer() {
		return "user-view/transfer-view";
	}
	
	@RequestMapping("/newAccount")
	public String newAccount() {
		return "entry/make-account";
	}

}
