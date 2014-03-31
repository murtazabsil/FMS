/**
 * 
 */
package com.bluestar.fms.bso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.dal.ActualDAO;
import com.bluestar.fms.dal.ActualDAOImpl;
import com.bluestar.fms.dal.ForecastDAO;
import com.bluestar.fms.dal.ForecastDAOImpl;
import com.bluestar.fms.entity.Actual;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.util.ActualUtil;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ActualVO;
import com.bluestar.fms.vo.ForecastVO;

/**
 * @author KHAN
 * 
 */
public class ActualBSOImpl implements ActualBSO {

	@Override
	public List<ActualVO> getActualList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActualDAO actualDAO = null;
		List<ActualVO> actualVOList = null;
		try {
			actualDAO = new ActualDAOImpl();
			Long projectId = Long.parseLong(request.getParameter("projectId"));
			Long forecastId = 0l;
			if (request.getParameter("forecastId") != null)
				forecastId = Long.parseLong(request.getParameter("forecastId"));
			actualVOList = actualDAO.getActualList(projectId, forecastId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualVOList;
	}

	@Override
	public ActualVO getActualDetails(Long actualId) {
		// TODO Auto-generated method stub
		ActualDAO actualDAO = null;
		ActualVO actualVO = null;
		try {
			actualDAO = new ActualDAOImpl();
			Actual actual = actualDAO.getActualDetails(actualId);
			actualVO = ActualUtil.getActualVOFromEntity(actual);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualVO;
	}

	@Override
	public void addActual(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActualVO actualVO = null;
		ActualDAO actualDAO = null;
		Actual actual = null;
		try {
			actualDAO = new ActualDAOImpl();
			actualVO = ActualUtil.convertRequestToActualVO(request);
			actual = ActualUtil.getActualEntityFromVO(actualVO);
			actual = actualDAO.addActual(actual);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	}

	@Override
	public boolean getIsActual(Long forecastId) {
		// TODO Auto-generated method stub
		boolean isActual = false;
		ActualDAO actualDAO = null;
		try {
			actualDAO = new ActualDAOImpl();
			isActual = actualDAO.getIsActualPresent(forecastId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return isActual;
	}

	@Override
	public Long getActualIdFromForecast(Long forecastId) {
		// TODO Auto-generated method stub
		Long actualId = 0l;
		ActualDAO actualDAO = null;
		try {
			actualDAO = new ActualDAOImpl();
			actualId = actualDAO.getActualIdFromForecast(forecastId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualId;
	}

}
