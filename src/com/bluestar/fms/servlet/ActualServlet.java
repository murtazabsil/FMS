package com.bluestar.fms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.bluestar.fms.bso.ActualBSO;
import com.bluestar.fms.bso.ActualBSOImpl;
import com.bluestar.fms.bso.ForecastBSO;
import com.bluestar.fms.bso.ForecastBSOImpl;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ActualVO;
import com.bluestar.fms.vo.ForecastVO;

/**
 * Servlet implementation class ForecastServlet
 */
public class ActualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualServlet() {
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
		ActualBSO actualBSO = null;
		ForecastBSO forecastBSO = null;
		try {
			actualBSO = new ActualBSOImpl();
			forecastBSO = new ForecastBSOImpl();
			String requestFrom = request.getParameter("requestFrom");
			if (requestFrom != null) {
				if (requestFrom.equalsIgnoreCase("ActualList")) {
					List<ActualVO> actualVOs = actualBSO.getActualList(request);
					request.setAttribute("actualList", actualVOs);
					request.setAttribute("Path", "ActualList");
				}
				if (requestFrom.equalsIgnoreCase("ActualEdit")) {
					Long actualId = Long.parseLong(request.getParameter("id"));
					ActualVO actualVO = actualBSO.getActualDetails(actualId);
					request.setAttribute("actualVO", actualVO);
					request.setAttribute("Path", "EditActual");
				}
				if (requestFrom.equalsIgnoreCase("IsActual")) {
					Long forecastId = Long.parseLong(request
							.getParameter("forecastId"));
					boolean isActualPresent = actualBSO.getIsActual(forecastId);
					ForecastVO forecastVO = forecastBSO
							.getForecastDetails(forecastId);
					request.setAttribute("forecastVO", forecastVO);
					if (isActualPresent) {
						Long actualId = actualBSO
								.getActualIdFromForecast(forecastId);
						ActualVO actualVO = actualBSO
								.getActualDetails(actualId);
						request.setAttribute("actualVO", actualVO);
						request.setAttribute("Path", "EditActual");
					} else {
						request.setAttribute("Path", "AddActual");
					}
				}
				if (requestFrom.equalsIgnoreCase("actualListFromProjectId")) {
					List<ActualVO> actualVOs = actualBSO.getActualList(request);
					Map<Long, String> map = new HashMap<Long, String>();
					for (ActualVO actualVO : actualVOs)
						map.put(actualVO.getActualId(),
								actualVO.getActualName());
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
				if (requestFrom.equalsIgnoreCase("actualForCompare")) {
					Long actualId = Long.parseLong(request
							.getParameter("actualId"));
					ActualVO actualVO = actualBSO.getActualDetails(actualId);
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					for (int index = 1; index <= 12; index++) {
						if (actualVO.getActualData()[index] != null)
							if (actualVO.getActualData()[index] != 0) {
								map.put(index, actualVO.getActualData()[index]);
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
		ActualBSO actualBSO = null;
		ForecastBSO forecastBSO = null;
		try {
			actualBSO = new ActualBSOImpl();
			forecastBSO = new ForecastBSOImpl();
			String requestFrom = request.getParameter("requestFrom");
			if (requestFrom != null) {
				if (requestFrom.equalsIgnoreCase("AddActual")) {
					actualBSO.addActual(request);
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
