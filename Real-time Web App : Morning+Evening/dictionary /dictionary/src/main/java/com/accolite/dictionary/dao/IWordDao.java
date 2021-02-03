package com.accolite.dictionary.dao;

import java.util.List;

import com.accolite.dictionary.entities.Word;

public interface IWordDao {

	Word save(Word word);
	
	List<Word> getAllBooks();
	
	int delete(int id);
	
	Word update(Word word);
	
	List<Word> pattern(String pattern);

}
