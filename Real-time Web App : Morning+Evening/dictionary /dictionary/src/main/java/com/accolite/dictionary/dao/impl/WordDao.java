package com.accolite.dictionary.dao.impl;

import java.util.List;
//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.accolite.dictionary.dao.IWordDao;
import com.accolite.dictionary.entities.Word;
import com.accolite.dictionary.queries.WordQueries;
import com.accolite.dictionary.table.constants.WordTableConstants;

@Repository
public class WordDao implements IWordDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static Logger logger = LoggerFactory.getLogger(WordDao.class);

	@Override
	public Word save(Word word) {
		final KeyHolder holder = new GeneratedKeyHolder();
		String sql = "INSERT INTO WORDS ( WORD , MEANING , PART_OF_SPEECH , EXAMPLE , CREATION_TM , LAST_MODIFIED_TM ) "
				+ " VALUES ( :WORD , :MEANING , :PART_OF_SPEECH , :EXAMPLE , :CREATION_TM , :LAST_MODIFIED_TM )";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("WORD", word.getWord());
		srcMap.addValue("MEANING",word.getMeaning());
		srcMap.addValue("PART_OF_SPEECH",word.getPartOfSpeech());
		srcMap.addValue("EXAMPLE",word.getExample());
		srcMap.addValue("CREATION_TM",word.getCreationTm());
		srcMap.addValue("LAST_MODIFIED_TM",word.getLastModifiedTm());
		
		namedParameterJdbcTemplate.update(sql, srcMap,
		        holder, new String[] {"ID"});
		word.setId(holder.getKey().intValue());
		return word;
	}
	
	@Override
	public List<Word> getAllBooks(){
		String sql = "SELECT * FROM WORDS";
		
		return namedParameterJdbcTemplate.query(sql,(resultSet, rowNum) -> {
			Word word = new Word();
			word.setId(resultSet.getInt("ID"));
			word.setCreationTm(resultSet.getDate("CREATION_TM"));
			word.setExample(resultSet.getString("EXAMPLE"));
			word.setLastModifiedTm(resultSet.getDate("LAST_MODIFIED_TM"));
			word.setMeaning(resultSet.getString("MEANING"));
			word.setPartOfSpeech(resultSet.getString("PART_OF_SPEECH"));
			word.setWord(resultSet.getString("WORD"));
			return word;
		});	
	}

	@Override
	public int delete(int id) {
//		String deleteQuery = "DELETE FROM WORDS WHERE ID = :ID";
//		Logger.info(WordQueries.DELETE_QUERY);
//		MapSqlParameterSource srcMap = new MapSqlParameterSource();
//		srcMap.addValue(WordTableConstants.ID, id);
		logger.info(WordQueries.DELETE_QUERY);
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.ID, id);
		return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
	}

	@Override
	public Word update(Word word) {
		final KeyHolder holder = new GeneratedKeyHolder();
		String sql = "UPDATE "+WordTableConstants.TABLE_NAME+" SET +"+WordTableConstants.WORD+" = :"+WordTableConstants.WORD+" , "+WordTableConstants.MEANING+" = :"+WordTableConstants.MEANING+" , "+WordTableConstants.POS+" = :"+WordTableConstants.POS+", "+WordTableConstants.EXAMPLE+" = :"+WordTableConstants.EXAMPLE+" , "+WordTableConstants.CREATION_TM+" = :"+WordTableConstants.CREATION_TM+" , "+WordTableConstants.LAST_MODIFIED_TM+" = :"+WordTableConstants.LAST_MODIFIED_TM+" WHERE +"+WordTableConstants.ID+" = :"+WordTableConstants.ID;
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.WORD, word.getWord());
		srcMap.addValue(WordTableConstants.MEANING,word.getMeaning());
		srcMap.addValue(WordTableConstants.POS,word.getPartOfSpeech());
		srcMap.addValue(WordTableConstants.EXAMPLE,word.getExample());
		srcMap.addValue(WordTableConstants.CREATION_TM,word.getCreationTm());
		srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM,word.getLastModifiedTm());
		
		namedParameterJdbcTemplate.update(sql, srcMap,
		        holder, new String[] {"ID"});
		word.setId(holder.getKey().intValue());
		return word;
	}
	
	@Override
	public List<Word> pattern(String pattern) {
		String sql = "SELECT * FROM " + WordTableConstants.TABLE_NAME + " where "+ WordTableConstants.WORD + " LIKE :" + WordTableConstants.WORD + " ";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.WORD, "%" + pattern + "%");
		return namedParameterJdbcTemplate.query(sql, srcMap, (resultSet, rowNum) -> {
			Word word = new Word();
			word.setId(resultSet.getInt(WordTableConstants.ID));
			word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
			word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
			word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
			word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
			word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
			word.setWord(resultSet.getString(WordTableConstants.WORD));
			return word;
		});
	}
}
