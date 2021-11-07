package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userPage")
public class OperationController {
	
	@RequestMapping("")
	public String userPage() {
		return "user-view/home";
	}

}
