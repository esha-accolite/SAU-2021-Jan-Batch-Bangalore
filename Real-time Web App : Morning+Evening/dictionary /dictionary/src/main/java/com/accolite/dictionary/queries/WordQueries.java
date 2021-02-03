package com.accolite.dictionary.queries;

import com.accolite.dictionary.table.constants.WordTableConstants;

public class WordQueries {
	
//	private static final String deleteQuery = "DELETE FROM WORDS WHERE ID = :ID";
	public static final String DELETE_QUERY = "DELETE FROM "+WordTableConstants.TABLE_NAME+" WHERE "+WordTableConstants.ID+"=:"+WordTableConstants.ID;
}
