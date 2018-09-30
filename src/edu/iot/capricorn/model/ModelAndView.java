package edu.iot.capricorn.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ModelAndView {
	
	private String view;				// 이동할 페이지
	private Map<String, Object> map;	// scope 에 넣을 정보들
	
	public ModelAndView() {
		map = new HashMap<>();
	}
	
	public void addAttribute(String key, Object value) {
		map.put(key, value);
	}
	
	public void addAtrribute(Map<String, Object> map) {
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			Object value = map.get(key);
			this.map.put(key, value);
		}
	}

}
