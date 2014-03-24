package com.bluestar.fms.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.bso.ForecastBSO;
import com.bluestar.fms.bso.ForecastBSOImpl;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.entity.ForecastDetail;
import com.bluestar.fms.vo.ForecastVO;

public class ForecastUtil {

	public static Forecast getForecastEntityFromVO(ForecastVO forecastVO) {
		Forecast forecast = null;
		ForecastDetail forecastDetail = null;
		List<ForecastDetail> list = null;
		ForecastBSO forecastBSO = null;
		try {
			forecastBSO = new ForecastBSOImpl();
			forecast = new Forecast();
			list = new ArrayList<ForecastDetail>();
			forecast.setForecastName(forecastVO.getForecastName());
			forecast.setForecastYear(forecastVO.getForecastYear());
			forecast.setForecastMonth(forecastBSO.getMonthById(forecastVO
					.getForecastMonth()));
			forecast.setProjectId(forecastBSO.getProjectById(forecastVO
					.getProjectId()));
			forecast.setCreatedBy(forecastBSO.getManagerById(forecastVO
					.getCreatedBy()));
			forecast.setCreatedOn(forecastVO.getCreatedOn());
			for (int index = 1; index <= 12; index++) {
				if (forecastVO.getForecastData()[index] != null) {
					forecastDetail = new ForecastDetail();
					forecastDetail.setCost(forecastVO.getForecastData()[index]);
					forecastDetail.setMonthId(forecastBSO.getMonthById(index));
					forecastDetail.setForecastId(forecast);
					list.add(forecastDetail);
				}
			}
			forecast.setForecastDetailCollection(list);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecast;
	}

	public static ForecastVO convertRequestToForecastVO(
			HttpServletRequest request) {
		ForecastVO forecastVO = null;
		try {
			forecastVO = new ForecastVO();
			forecastVO.setForecastName(request.getParameter("forecast-name"));
			forecastVO.setForecastYear(Integer.parseInt(request
					.getParameter("forecast-year")));
			forecastVO.setForecastMonth(Integer.parseInt(request
					.getParameter("forecast-month")));
			forecastVO.setProjectId(Integer.parseInt(request
					.getParameter("projectId")));
			forecastVO.setCreatedBy((Long) request.getSession().getAttribute(
					"userRegId"));
			forecastVO.setCreatedOn(CommonUtil.getStringToDate(CommonUtil
					.getDatetoString(new Date())));
			Double[] forecastData = new Double[13];
			// Get Data for entire month data.
			for (int index = 1; index <= 12; index++) {
				if (request.getParameter(String.valueOf(index)) != null
						&& !"".equals(request.getParameter(String
								.valueOf(index)))) {
					forecastData[index] = Double.parseDouble(request
							.getParameter(String.valueOf(index)));
				}
			}
			forecastVO.setForecastData(forecastData);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecastVO;
	}

	public static ForecastVO getForecastVOFromForecast(Forecast forecast) {
		ForecastVO forecastVO = null;
		try {
			forecastVO = new ForecastVO();
			forecastVO.setForecastId(forecast.getForecastId());
			forecastVO.setForecastName(forecast.getForecastName());
			forecastVO.setForecastYear(forecast.getForecastYear());
			forecastVO.setForecastMonth(forecast.getForecastMonth()
					.getMonthId());
			forecastVO.setProjectId(forecast.getProjectId().getProjectId());
			forecastVO.setCreatedBy(forecast.getCreatedBy().getManagerId());
			forecastVO.setProjectName(forecast.getProjectId().getProjectName());
			forecastVO.setCreatedByName(forecast.getCreatedBy()
					.getManagerName());
			forecastVO.setCreatedOn(forecast.getCreatedOn());
			forecastVO.setCreatedOnDesc(CommonUtil.getDatetoString(forecast
					.getCreatedOn()));
			forecastVO.setForecastMonthDesc(forecast.getForecastMonth()
					.getMonthName());
			/*
			 * for (int index = 1; index <= 12; index++) { if
			 * (forecastVO.getForecastData()[index] != null) { forecastDetail =
			 * new ForecastDetail();
			 * forecastDetail.setCost(forecastVO.getForecastData()[index]);
			 * forecastDetail.setMonthId(forecastBSO.getMonthById(index));
			 * forecastDetail.setForecastId(forecast); list.add(forecastDetail);
			 * } } forecast.setForecastDetailCollection(list);
			 */
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecastVO;
	}
}
