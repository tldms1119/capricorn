package edu.iot.capricorn.controller.gallery;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.controller.BasicServlet;
import edu.iot.capricorn.model.ModelAndView;
import edu.iot.capricorn.service.GalleryService;

@WebServlet("/gallery")
public class GalleryServlet extends BasicServlet {
	GalleryService service = Context.get(GalleryService.class);
	
	@Override
	protected void get(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getServletContext().getRealPath("/images");
		
		mav.addAttribute("list", service.getImages(path));
		
		mav.setView("/gallery/gallery.jsp");
	}
	
	
}
