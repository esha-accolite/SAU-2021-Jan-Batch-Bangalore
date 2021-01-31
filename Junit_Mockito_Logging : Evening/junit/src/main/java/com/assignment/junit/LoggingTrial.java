package com.assignment.junit;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTrial {

	private static final Logger log= Logger.getLogger(LoggingTrial.class.getName());
	
    public static void main(String[] args) throws SecurityException, IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	String level = sc.nextLine();
    	
    	if(level.equals("SEVERE"))
    		log.setLevel(Level.SEVERE);
    	else if(level.equals("WARNING"))
    		log.setLevel(Level.WARNING);
    	else if(level.equals("INFO"))
    		log.setLevel(Level.INFO);
    	else if(level.equals("CONFIG"))
    		log.setLevel(Level.CONFIG);
    	else if(level.equals("FINE"))
    		log.setLevel(Level.FINE);
    	else if(level.equals("FINER"))
    		log.setLevel(Level.FINER);
    	else if(level.equals("FINEST"))
    		log.setLevel(Level.FINEST);
    	else
    		System.out.println("Invalid Input");
    	
        log.info("Info log");
         
        log.warning("Warning log");
        
        log.fine("Fine log");
        
        log.finer("Finer log");
        
        log.finest("Finest log");
     
        log.config("Config log");
        
        log.severe("Severe log");
    }
}