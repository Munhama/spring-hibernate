package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// method to show the initial HTML form 
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// method to read from controller and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String nameToUpper(HttpServletRequest request, Model model) {
		
		// read the request parameters from the HTML form
		String name = request.getParameter("nameForm");
		
		// convert data to upper case
		name = name.toUpperCase();
		
		// create new message
		String newMessage = "Yo! " + name;
		
		// add message to the model
		model.addAttribute("message", newMessage);
		
		return "helloworld";
	}
}
