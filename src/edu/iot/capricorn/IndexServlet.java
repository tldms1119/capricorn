package edu.iot.capricorn;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.controller.BasicServlet;
import edu.iot.capricorn.model.ModelAndView;
import edu.iot.capricorn.service.Top100Service;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	
	Top100Service service = Context.get(Top100Service.class);

	@Override
	protected void get(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		mav.addAttribute("list", service.random(5));
		mav.addAttribute("list2", service.random(6));
		mav.setView("/index.jsp");
	}

}
