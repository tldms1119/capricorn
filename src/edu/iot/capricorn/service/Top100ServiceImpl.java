package edu.iot.capricorn.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.dao.Top100Dao;
import edu.iot.capricorn.model.Top100;

public class Top100ServiceImpl implements Top100Service {
	
	Top100Dao dao = Context.get(Top100Dao.class);
	
	@Override
	public List<Top100> random(int num) throws Exception {
		List<Top100> list = dao.random(num);

		for(Top100 item: list) {
			List<String> imageList = new ArrayList<>();
			imageList.add("1.JPG");
			imageList.add("2.JPG");
			imageList.add("3.jpeg");
			imageList.add("4.JPG");
			imageList.add("5.JPG");
			imageList.add("6.JPG");
			imageList.add("7.JPG");
			imageList.add("8.JPG");
			imageList.add("9.JPG");
			imageList.add("10.JPG");
			Collections.shuffle(imageList);
			item.setImageList(imageList);
		}
		
		return list;
	}

}
