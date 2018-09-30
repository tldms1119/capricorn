package edu.iot.capricorn.dao;

import edu.iot.capricorn.model.Top100;
import edu.iot.common.dao.CrudDaoImpl;

public class Top100DaoImpl extends CrudDaoImpl<Top100, Long> 
							implements Top100Dao {

	public Top100DaoImpl() {
		super("Top100Dao");
	}

}
