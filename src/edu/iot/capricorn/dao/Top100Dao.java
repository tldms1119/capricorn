package edu.iot.capricorn.dao;

import edu.iot.capricorn.model.Top100;
import edu.iot.common.dao.CrudDao;
import edu.iot.common.dao.RandomDao;

public interface Top100Dao extends CrudDao<Top100, Long>,  
									RandomDao<Top100> {

}
