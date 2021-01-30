package com.namegenerator.au;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/stringOperation")
public class StringOperations {
	
	@GetMapping("/concatenate/{string1}/{string2}")
	public String concatenate(@PathVariable("string1") String string1, @PathVariable("string2") String string2) {
		return string1+string2;
	}
	
	@GetMapping("/split/{string1}/{string2}")
	public String split(@PathVariable("string1") String string1, @PathVariable("string2") String string2) {
		return string1.split(string2)[0];
	}
	
	@GetMapping("/length/{string1}")
	public int length(@PathVariable("string1") String string1) {
		return string1.length();
	}
	
	@GetMapping("/subString/{string1}/{start}/{end}")
	public String subString(@PathVariable("string1") String string1, @PathVariable("start") Integer start,@PathVariable("end") Integer end) {
		return string1.substring(start,end);
	}
	
	@GetMapping("/equals/{string1}/{string2}")
	public Boolean equals(@PathVariable("string1") String string1, @PathVariable("string2") String string2) {
		return string1.equals(string2);
	}
	
	@GetMapping("/replace/{string1}/{char1}/{char2}")
	public String replace(@PathVariable("string1") String string1, @PathVariable("char1") String char1, @PathVariable("char2") String char2) {
		return string1.replace(char1,char2);
	}
	
	@GetMapping("/lowerCase/{string1}")
	public String lowerCase(@PathVariable("string1") String string1) {
		return string1.toLowerCase();
	}
	
	@GetMapping("/upperCase/{string1}")
	public String upperCase(@PathVariable("string1") String string1) {
		return string1.toUpperCase();
	}
	
	@GetMapping("/index/{string1}/{char1}")
	public Integer index(@PathVariable("string1") String string1,@PathVariable("char1") String char1) {
		return string1.indexOf(char1);
	}
}
