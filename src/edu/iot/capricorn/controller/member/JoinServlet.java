package edu.iot.capricorn.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.model.Member;
import edu.iot.capricorn.model.UserLevel;
import edu.iot.capricorn.service.MemberService;
import edu.iot.common.sec.SHA256Util;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//MemberDao dao = new MemberDaoImpl();
	MemberService service = Context.get(MemberService.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("member") == null) {
			Member member = Member.builder()
							.userId("raccoon")
							.name("test")
							.phoneNumber("010-1111-1111")
							.nickName("test")
							.email("test@naver.com")
							.address("서울시 강남구")
							.build();
			request.setAttribute("member", member);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/account/join.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = map(request);
		
		try {
			service.join(member);
			String url = request.getContextPath() + "/login";
			response.sendRedirect(url);
			
		} catch (Exception e) {
			// join.jsp 로 forward
			request.setAttribute("error", "저장 실패");
			request.setAttribute("member", member);
			doGet(request, response);
		}
		
	}
	
	private Member map(HttpServletRequest request) {
		String salt = SHA256Util.generateSalt();
		String password = SHA256Util.getEncrypt(request.getParameter("pw"), salt);
		
		Member member = Member.builder()
				.userId(request.getParameter("id"))
				.password(password)
				.salt(salt)
				.name(request.getParameter("name"))
				.phoneNumber(request.getParameter("phone"))
				.nickName(request.getParameter("nickname"))
				.userLevel(UserLevel.NORMAL)
				.email(request.getParameter("email"))
				.address(request.getParameter("address"))
				.build();
		return member;
	}

}
