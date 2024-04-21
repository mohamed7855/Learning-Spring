package com.learning.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String processForm(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		model.addAttribute("Name",name);
		
		return "helloworld";
	}
}
