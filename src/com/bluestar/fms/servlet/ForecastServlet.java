package com.bluestar.fms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.ObjectMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

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
		ForecastBSO forecastBSO = null;
		try {
			forecastBSO = new ForecastBSOImpl();
			String requestFrom = request.getParameter("requestFrom");
			if (requestFrom != null) {
				if (requestFrom.equalsIgnoreCase("ForecastList")) {
					List<ForecastVO> forecastVOs = forecastBSO
							.getForecastList(request);
					request.setAttribute("forecastList", forecastVOs);
					request.setAttribute("Path", "ForecastList");
				}
				if (requestFrom.equalsIgnoreCase("ForecastEdit")) {
					Long forecastId = Long
							.parseLong(request.getParameter("id"));
					ForecastVO forecastVO = forecastBSO
							.getForecastDetails(forecastId);
					request.setAttribute("forecastVO", forecastVO);
					request.setAttribute("Path", "EditForecast");
				}
				if (requestFrom.equalsIgnoreCase("forecastListFromProjectId")) {
					List<ForecastVO> forecastVOs = forecastBSO
							.getForecastList(request);
					Map<Long, String> map = new HashMap<Long, String>();
					for (ForecastVO forecastVO : forecastVOs)
						map.put(forecastVO.getForecastId(),
								forecastVO.getForecastName());
					JSONObject jsonObject = new JSONObject(map);
					response.setContentType("application/json");
					// Get the printwriter object from response to write the
					// required json object to the output stream
					PrintWriter out = response.getWriter();
					// Assuming your json object is **jsonObject**, perform the
					// following, it will return your json object
					out.print(jsonObject.toString());
					out.flush();
				}
				if (requestFrom.equalsIgnoreCase("ForecastForCompare")) {
					Long forecastId = Long.parseLong(request
							.getParameter("forecastId"));
					ForecastVO forecastVO = forecastBSO
							.getForecastDetails(forecastId);
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					for (int index = 1; index <= 12; index++) {
						if (forecastVO.getForecastData()[index] != null)
							if (forecastVO.getForecastData()[index] != 0) {
								map.put(index,
										forecastVO.getForecastData()[index]);
							}
					}
					JSONObject jsonObject = new JSONObject(map);
					response.setContentType("application/json");
					// Get the printwriter object from response to write the
					// required json object to the output stream
					PrintWriter out = response.getWriter();
					// Assuming your json object is **jsonObject**, perform the
					// following, it will return your json object
					out.print(jsonObject.toString());
					out.flush();
				}
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
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
			if (requestFrom != null) {
				if (requestFrom.equalsIgnoreCase("AddForecast")) {
					forecastBSO.addForecast(request);
					List<ForecastVO> forecastVOs = forecastBSO
							.getForecastList(request);
					request.setAttribute("forecastList", forecastVOs);
					request.setAttribute("Path", "ForecastList");
				}
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	}

}
