package com.bluestar.fms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluestar.fms.util.PrintStackTraceLogger;

/**
 * Servlet implementation class ForecastServlet
 */
public class ForecastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForecastServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String requestFrom = request.getParameter("requestFrom");
			if(requestFrom != null){
				if(requestFrom.equalsIgnoreCase("AddForecast")){
					
				}
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	}

}
