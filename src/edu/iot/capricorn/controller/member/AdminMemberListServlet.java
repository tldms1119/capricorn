package edu.iot.capricorn.controller.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.service.MemberService;
import edu.iot.capricorn.utility.Util;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/admin/member/list")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = Context.get(MemberService.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Util.getInt(request.getParameter("page"), 1);
		String userId = request.getParameter("userId");
		
		
		String today = Util.getToday();
		Map<String, Object> map = null;	
		try {
			if(userId == null) {							// 회원 관리로 바로 넘어온 경우(Search 안함)
				map = service.getPage(page);				
			} else {										// 공백 "" 입력하면 전체리스트 출력
				map = service.search(page, userId);
			}
		
			Util.toScope(request, map);
			request.setAttribute("today", today);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/member/list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
