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

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter({"/member/*", "/admin/*"})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
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
		
		Member user = (Member)session.getAttribute("USER");
		if(user != null) {									// 로그인 된 상태면
			chain.doFilter(request, response);				// 다음 필터로 이동
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("message", "로그인이 필요한 서비스 입니다");
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
