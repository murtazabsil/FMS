package com.bluestar.fms.bso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.dal.ForecastDAO;
import com.bluestar.fms.dal.ForecastDAOImpl;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ForecastVO;

public class ForecastBSOImpl implements ForecastBSO {

	@Override
	public void addForecast(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ForecastVO forecastVO = null;
		ForecastDAO forecastDAO = null;
		Forecast forecast = null;
		try {
			forecastDAO = new ForecastDAOImpl();
			forecastVO = ForecastUtil.convertRequestToForecastVO(request);
			forecast = ForecastUtil.getForecastEntityFromVO(forecastVO);
			forecast = forecastDAO.addForecast(forecast);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	}

	@Override
	public Month getMonthById(Integer monthId) {
		ForecastDAO forecastDAO = new ForecastDAOImpl();
		Month month = forecastDAO.getMonthById(monthId);
		return month;
	}

	@Override
	public List<ForecastVO> getForecastList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ForecastDAO forecastDAO = null;
		List<ForecastVO> forecastVOs = null;
		try {
			forecastDAO = new ForecastDAOImpl();
			Long projectId = 0l;
			Long createdBy = 0l;
			if (request.getParameter("projectId") != null
					&& !"".equals(request.getParameter("projectId")))
				projectId = Long.parseLong(request.getParameter("projectId"));
			if (projectId != 0) {
				forecastVOs = forecastDAO.getForecastList(projectId);
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecastVOs;
	}

	@Override
	public Project getProjectById(Long projectId) {
		ForecastDAO forecastDAO = new ForecastDAOImpl();
		Project project = forecastDAO.getProjectById(projectId);
		return project;
	}

	@Override
	public Manager getManagerById(Long managerId) {
		ForecastDAO forecastDAO = new ForecastDAOImpl();
		Manager manager = forecastDAO.getManagerById(managerId);
		return manager;
	}

}
