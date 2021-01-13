package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {

	  @Autowired
	  CricketRepository cricketRepository;
	  
	  @PostMapping("/Cricket")
	    public Cricket addCricketPost(@RequestBody Cricket cricket) {
	        return cricketRepository.save(cricket);
	    }
	  @GetMapping("/Cricket/runs/{runs}")
	    public Cricket findByruns(@PathVariable int runs) {
		 
	       
	        List<Cricket> players = (List<Cricket>) cricketRepository.findAll();
	        
	        
	        List<Cricket> result = new ArrayList<Cricket>();
	        
	        for(int i = 0;i<players.size();i++) 
	        {	
	            if(players.get(i).getruns() > runs)
	            {
	            	result.add(players.get(i));
	            }
	            System.out.println("Runs : "+ players.get(i).getruns());
	        }
	        return result.get(0);
	    }
}
