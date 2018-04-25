package com.chinasofti.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
    	System.out.println("-------过滤器关闭-------");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object userName = session.getAttribute("userName");
		if(userName==null){
			request.setAttribute("msg", "该页面需要登录后才能访问,请先登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("-------过滤器开启-------");

	}

}
