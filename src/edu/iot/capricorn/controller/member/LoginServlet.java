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
import edu.iot.capricorn.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	MemberDao dao = new MemberDaoImpl();
	MemberService service = Context.get(MemberService.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String destination = request.getParameter("destination");
		
		try {
			Member member = service.login(id, pw);
			request.getSession().setAttribute("USER", member);
			
			if(!destination.isEmpty()) {
				response.sendRedirect(destination);
			} else {
				String url = request.getContextPath() + "/index";
				response.sendRedirect(url);
			}
				
		} catch(Exception e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("userId", id);
			request.setAttribute("destination", destination);
			doGet(request, response);
		}
		
	}

}
