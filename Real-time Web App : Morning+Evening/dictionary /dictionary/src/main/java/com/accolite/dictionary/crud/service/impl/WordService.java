package com.accolite.dictionary.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.dictionary.crud.services.IWordService;
import com.accolite.dictionary.dao.IWordDao;
import com.accolite.dictionary.entities.Word;

@Service
public class WordService implements IWordService {

	@Autowired
	IWordDao iWordDao;
	
	@Override
	public Word save(Word word) {
		return iWordDao.save(word);
	}

	@Override
	public List<Word> getAll() {
		List<Word> books = iWordDao.getAllBooks();
		return books;
	}
	
	@Override
	public boolean delete(int id) {
		int rowsAffected = iWordDao.delete(id);
		if (rowsAffected == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Word update(Word word) {
		return iWordDao.update(word);
	}

	@Override
	public List<Word> pattern(String pattern) {
		return iWordDao.pattern(pattern);
	}
	
}
