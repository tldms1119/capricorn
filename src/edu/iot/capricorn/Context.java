package edu.iot.capricorn;

import java.util.HashMap;
import java.util.Map;

import edu.iot.capricorn.dao.MemberDao;
import edu.iot.capricorn.dao.MemberDaoImpl;
import edu.iot.capricorn.dao.Top100Dao;
import edu.iot.capricorn.dao.Top100DaoImpl;
import edu.iot.capricorn.service.GalleryService;
import edu.iot.capricorn.service.GalleryServiceImpl;
import edu.iot.capricorn.service.MemberService;
import edu.iot.capricorn.service.MemberServiceImpl;
import edu.iot.capricorn.service.Top100Service;
import edu.iot.capricorn.service.Top100ServiceImpl;

public class Context {
	static private Map<Class, Object> map;
	
	static {
		map = new HashMap<>();
		map.put(MemberDao.class, new MemberDaoImpl());
		map.put(MemberService.class, new MemberServiceImpl());
		map.put(GalleryService.class, new GalleryServiceImpl());
		map.put(Top100Dao.class, new Top100DaoImpl());
		map.put(Top100Service.class, new Top100ServiceImpl());
	}
	
	public static <T> T get(Class<T> clazz) {
		Object obj = map.get(clazz);
		return clazz.cast(obj);
	}
	
	
}
