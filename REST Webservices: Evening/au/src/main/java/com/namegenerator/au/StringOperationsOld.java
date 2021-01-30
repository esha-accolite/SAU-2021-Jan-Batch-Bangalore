package com.namegenerator.au;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/stringOperationsOld")
public class StringOperationsOld {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String generate(String firstname, String lastname) {
		return firstname+lastname;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String concatenate(String string1, String string2) {
		return string1+string2;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String split(String string1, String string2) {
		return string1.split(string2)[0];
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int length(String string1) {
		return string1.length();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String subString(String string1, Integer start,Integer end) {
		return string1.substring(start,end);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean equals(String string1, String string2) {
		return string1.equals(string2);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String replace(String string1,String char1, String char2) {
		return string1.replace(char1,char2);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String lowerCase(String string1) {
		return string1.toLowerCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String upperCase(String string1) {
		return string1.toUpperCase();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Integer index(String string1, String char1) {
		return string1.indexOf(char1);
	}
	

}
