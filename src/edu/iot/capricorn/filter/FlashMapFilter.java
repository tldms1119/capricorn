package edu.iot.capricorn.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import edu.iot.capricorn.utility.Util;

/**
 * Servlet Filter implementation class FlashMapFilter
 */
@WebFilter("/*")
public class FlashMapFilter implements Filter {

    public FlashMapFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Map<String, Object> map = (Map) req.getSession().getAttribute("FLASH");
		
		if(map != null) {
			Util.toScope(req, map);
			req.getSession().removeAttribute("FLASH");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
