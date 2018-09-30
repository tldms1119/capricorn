package edu.iot.capricorn.controller.member;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.controller.BasicServlet;
import edu.iot.capricorn.model.Member;
import edu.iot.capricorn.model.ModelAndView;
import edu.iot.capricorn.service.MemberService;
import edu.iot.capricorn.utility.Property;
import edu.iot.common.sec.SHA256Util;

@WebServlet("/member/update")
public class MemberUpdateServlet extends BasicServlet {
	MemberService service =  Context.get(MemberService.class);
	
	@Override
	protected void get(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = (Member) request.getSession().getAttribute("USER");
		
		mav.addAttribute("member", member);
		mav.setView("/member/update.jsp");
	}
	
	@Override
	protected void post(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = Property.parse(request, Member.class);		// map 함수를 대신해주는 역할
		Member sMember = (Member) request.getSession().getAttribute("USER");
	
		int result = service.update(member, sMember);
		if(result == 1) {		
			member = service.findById(member.getUserId());
			request.getSession().setAttribute("USER", member);
			mav.setView("redirect:view");
		} else {
			mav.addAttribute("error", "비밀번호가 일치하지 않습니다");
			mav.addAttribute("member", member);
			mav.setView("/member/update.jsp");
		}
	}
}
