package edu.iot.capricorn.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.iot.capricorn.model.Member;
import edu.iot.capricorn.model.UserLevel;

/**
 * Servlet Filter implementation class AdminCheckFilter
 */
@WebFilter("/admin/*")
public class AdminCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Member user = (Member) session.getAttribute("USER");
		
		if(user != null && user.getUserLevel() == UserLevel.ADMIN) {
			chain.doFilter(request, response);	
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("message", "권한이 없습니다");
			map.put("destination", req.getRequestURI());
			session.setAttribute("FLASH", map);
			res.sendRedirect(req.getContextPath() + "/login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
