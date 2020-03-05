package ca.foc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

	@RequestMapping("/home")
	public String Welcome() {
	return "Welcome page";
	}
	
	@RequestMapping("/register")
	public String Registration() {
	return "Welcome page";
	}
}
