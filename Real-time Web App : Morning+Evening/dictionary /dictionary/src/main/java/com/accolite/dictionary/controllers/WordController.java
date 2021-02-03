package com.accolite.dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dictionary.crud.services.IWordService;
import com.accolite.dictionary.entities.Word;

@RestController
@RequestMapping("word")
public class WordController {
	
	@Autowired
	IWordService iWordService;
	
	@PostMapping("/save")
	public Word save(@RequestBody Word word) {
		return iWordService.save(word);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		return "Success";
	}
	
	@RequestMapping(value = "/getAllWords", method = RequestMethod.GET)
	public List<Word> getAllWords() {
		return iWordService.getAll();
	}
	
	@GetMapping(value = "/delete/{id}")
	public boolean deleteWord(@PathVariable int id) {
		return iWordService.delete(id);
	}
	
	@PutMapping("/update")
	public Word updateWord(@RequestBody Word word) {
		return iWordService.update(word);
	}
	
	@GetMapping("/pattern")
	public List<Word> pattern(@PathVariable String pattern) {
		return iWordService.pattern(pattern);
	}

}
