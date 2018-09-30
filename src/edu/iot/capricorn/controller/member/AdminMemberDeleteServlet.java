package edu.iot.capricorn.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iot.capricorn.Context;
import edu.iot.capricorn.service.MemberService;

/**
 * Servlet implementation class AdminMemberDeleteServlet
 */
@WebServlet("/admin/member/delete")
public class AdminMemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = Context.get(MemberService.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		try {
			int result = service.delete(userId);
			if(result != 1) {
				request.setAttribute("error", "삭제 실패");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/member/view.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/member/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
