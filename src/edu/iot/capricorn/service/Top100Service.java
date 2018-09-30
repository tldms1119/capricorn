package edu.iot.capricorn.service;

import java.util.List;

import edu.iot.capricorn.model.Top100;

public interface Top100Service {
	
	List<Top100> random(int num) throws Exception;
	
}
