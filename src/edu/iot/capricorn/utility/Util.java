package edu.iot.capricorn.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class Util {
	public static int getInt(String str, int defValue){
		try {
			if(str != null) {
				int page = Integer.parseInt(str);
				return page;
			}
		} catch(Exception e) {}	
		
		return defValue;
	}
	
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		return today;
	}
	
	public static void toScope(HttpServletRequest request, Map<String, Object> map) {
		Set<String> keys = map.keySet();
		for(String key : keys ) {
			Object value = map.get(key);
			request.setAttribute(key, value);
		}
		
	}
}
