package edu.iot.capricorn.service;

import java.io.File;
import java.io.FilenameFilter;

public class GalleryServiceImpl implements GalleryService {

	@Override
	public String[] getImages(String path) throws Exception {
		File file = new File(path);
		
		String[] list =  file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				if (name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg") ){
		            return true; 
		        } else {
		        	return false;
		        }
			}
			
		});
		
		return list;

	}

}
