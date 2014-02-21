package com.bluestar.fms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluestar.fms.bso.ForecastBSO;
import com.bluestar.fms.bso.ForecastBSOImpl;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ForecastVO;

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
		ForecastBSO forecastBSO = null;
		try {
			forecastBSO = new ForecastBSOImpl();
			String requestFrom = request.getParameter("requestFrom");
			if(requestFrom != null){
				if(requestFrom.equalsIgnoreCase("AddForecast")){
					forecastBSO.addForecast(request);
				}
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	}

}
