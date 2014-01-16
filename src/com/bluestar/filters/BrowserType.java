package com.bluestar.filters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.bluestar.fms.constants.CustomContants;

/**
 * Servlet Filter implementation class BrowserType
 */
public class BrowserType implements Filter {

	/**
	 * Default constructor.
	 */
	public BrowserType() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		chain.doFilter(request, response);

		// Redirecting to the specified jsp page on basis of device.
		String userAgent = null;
		String redirectedPage = null;
		RequestDispatcher view = null;
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			userAgent = httpServletRequest.getHeader("user-agent");
			redirectedPage = (String) httpServletRequest.getAttribute("Path");
			System.out.println(httpServletRequest.getRequestURL().toString());
			if(httpServletRequest.getRequestURL().toString().equalsIgnoreCase("Home")){
				redirectedPage = "Home";
			}
			if (redirectedPage != null) {
				if (userAgent.indexOf(CustomContants.ANDROID) != -1) {
					//view = httpServletRequest.getRequestDispatcher("mobile/"+redirectedPage+".jsp");
					view = httpServletRequest.getRequestDispatcher("jsp/"+redirectedPage+".jsp");
				} else if (userAgent.indexOf(CustomContants.IPHONE) != -1) {
				} else {
					view = httpServletRequest.getRequestDispatcher("jsp/"+redirectedPage+".jsp");
				}
				view.forward(httpServletRequest, httpServletResponse);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
