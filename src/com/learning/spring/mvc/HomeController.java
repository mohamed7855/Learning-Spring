package com.learning.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "Home";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
}
