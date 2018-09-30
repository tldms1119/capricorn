package edu.iot.capricorn.controller.member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.controller.BasicServlet;
import edu.iot.capricorn.model.ModelAndView;
import edu.iot.capricorn.service.MemberService;

@WebServlet("/member/view")
public class MemberViewServlet extends BasicServlet {
	MemberService service =  Context.get(MemberService.class);
	
	@Override
	protected void get(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		mav.setView("/member/view.jsp");
	}
}
