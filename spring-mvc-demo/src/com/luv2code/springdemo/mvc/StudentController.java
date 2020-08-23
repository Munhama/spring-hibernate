package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a student object
		Student student = new Student();
		
		// add student object to the model
		model.addAttribute("student", student);
		
		// add the country options to the model
		model.addAttribute("countryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		// log the input data
		System.out.println("First Name: " + student.getFirstName());
		System.out.println("Last Name: " + student.getLastName());
		System.out.println("Country: " + student.getCountry());
		System.out.println("Favorite Language: " + student.getFavoriteLanguage());
		System.out.println("Operating System:");
		for(String temp : student.getOperatingSystem())
			System.out.println(temp);
		
		return "studen-confirmation";
	}
}
