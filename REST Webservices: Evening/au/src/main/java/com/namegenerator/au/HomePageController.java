package com.namegenerator.au;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path="/")
public class HomePageController {

//	@GetMapping(value = "/get")
	@RequestMapping("/")
	public String home () {
		return "Home Page!";
	}
}