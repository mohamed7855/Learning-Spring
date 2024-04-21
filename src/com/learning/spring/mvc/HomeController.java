package com.learning.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String processForm(@RequestParam("studentName") String name, Model model) {
		
		name = name.toUpperCase();
		model.addAttribute("Name",name);
		
		return "helloworld";
	}
}
