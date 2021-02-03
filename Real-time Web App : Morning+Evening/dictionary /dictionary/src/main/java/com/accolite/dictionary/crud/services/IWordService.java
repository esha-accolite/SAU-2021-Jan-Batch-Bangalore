package com.accolite.dictionary.crud.services;

import java.util.List;

import com.accolite.dictionary.entities.Word;

public interface IWordService {

	public Word save(Word word);
	
	public List<Word> getAll();
	
	public boolean delete(int id);
	
	public Word update(Word word);
	
	public List<Word> pattern(String pattern);
}
