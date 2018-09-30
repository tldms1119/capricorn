package edu.iot.capricorn.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.controller.BasicServlet;
import edu.iot.capricorn.model.Member;
import edu.iot.capricorn.model.ModelAndView;
import edu.iot.capricorn.service.MemberService;
import edu.iot.capricorn.utility.Property;

@WebServlet("/member/change_password")
public class MemberChangePwServlet extends BasicServlet {
	MemberService service =  Context.get(MemberService.class);
	
	@Override
	protected void get(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = (Member) request.getSession().getAttribute("USER");
		
		mav.addAttribute("member", member);
		mav.setView("/member/change_password.jsp");
	}
	
	@Override
	protected void post(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Member member = (Member) request.getSession().getAttribute("USER");
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("member", member);
		map.put("oldPassword", request.getParameter("oldPassword"));
		map.put("newPassword", request.getParameter("newPassword"));
		
		int result = service.changePassword(map);
		if(result == 1) {		
			member = service.findById(member.getUserId());
			request.getSession().setAttribute("USER", member);
			request.getSession().setAttribute("success", "성공적으로 변경되었습니다");
			mav.setView("redirect:view");
		} else {
			mav.addAttribute("error", "비밀번호가 일치하지 않습니다");
			mav.addAttribute("member", member);
			mav.setView("/member/change_password.jsp");
		}
	}
}
