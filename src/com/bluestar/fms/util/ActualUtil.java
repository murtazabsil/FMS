package com.bluestar.fms.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.bso.ForecastBSO;
import com.bluestar.fms.bso.ForecastBSOImpl;
import com.bluestar.fms.entity.Actual;
import com.bluestar.fms.entity.ActualDetail;
import com.bluestar.fms.entity.ForecastDetail;
import com.bluestar.fms.vo.ActualVO;

public class ActualUtil {

	public static void getActualVOFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	public static ActualVO getActualVOFromEntity(Actual actual) {
		// TODO Auto-generated method stub
		ActualVO actualVO = null;
		try {
			actualVO = new ActualVO();
			actualVO.setActualId(actual.getActualId());
			actualVO.setActualName("Actual_"
					+ actual.getForecastId().getForecastName());
			actualVO.setCreatedBy(actual.getCreatedBy().getManagerId());
			actualVO.setCreatedByName(actual.getCreatedBy().getManagerName());
			actualVO.setCreatedOn((Date) actual.getCreatedOn());
			actualVO.setForecastId(actual.getForecastId().getForecastId());
			actualVO.setForecastName(actual.getForecastId().getForecastName());
			actualVO.setMonthName(actual.getForecastId().getForecastMonth()
					.getMonthName());
			actualVO.setProjectId(actual.getProjectId().getProjectId());
			actualVO.setProjectName(actual.getProjectId().getProjectName());
			Double[] actualData = new Double[13];
			for (ActualDetail actualDetail : actual.getActualDetailCollection()) {
				actualData[actualDetail.getMonthId().getMonthId()] = actualDetail
						.getCost();
			}
			actualVO.setActualData(actualData);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualVO;
	}

	public static ActualVO convertRequestToActualVO(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActualVO actualVO = null;
		try {
			actualVO = new ActualVO();
			if (request.getParameter("actualId") != null)
				actualVO.setActualId(Long.parseLong(request
						.getParameter("actualId")));
			actualVO.setCreatedBy((Long) request.getSession().getAttribute(
					"userRegId"));
			actualVO.setCreatedOn(CommonUtil.getStringToDate(CommonUtil
					.getDatetoString(new Date())));
			actualVO.setForecastId(Long.parseLong(request
					.getParameter("forecastId")));
			actualVO.setProjectId(Long.parseLong(request
					.getParameter("projectId")));
			Double[] actualData = new Double[13];
			// Get Data for entire month data.
			for (int index = 1; index <= 12; index++) {
				if (request.getParameter(String.valueOf(index)) != null
						&& !"".equals(request.getParameter(String
								.valueOf(index)))) {
					actualData[index] = Double.parseDouble(request
							.getParameter(String.valueOf(index)));
				}
			}
			actualVO.setActualData(actualData);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualVO;
	}

	public static Actual getActualEntityFromVO(ActualVO actualVO) {
		// TODO Auto-generated method stub
		Actual actual = null;
		ForecastBSO forecastBSO = null;
		ActualDetail actualDetail = null;
		List<ActualDetail> list = null;
		try {
			forecastBSO = new ForecastBSOImpl();
			list = new ArrayList<ActualDetail>();
			actual = new Actual();
			actual.setActualId(actualVO.getActualId());
			actual.setForecastId(forecastBSO.getForecastEntity(actualVO
					.getForecastId()));
			actual.setProjectId(forecastBSO.getProjectById(actualVO
					.getProjectId()));
			actual.setCreatedBy(forecastBSO.getManagerById(actualVO
					.getCreatedBy()));
			actual.setCreatedOn(actualVO.getCreatedOn());
			for (int index = 1; index <= 12; index++) {
				if (actualVO.getActualData()[index] != null) {
					actualDetail = new ActualDetail();
					actualDetail.setCost(actualVO.getActualData()[index]);
					actualDetail.setMonthId(forecastBSO.getMonthById(index));
					actualDetail.setActualId(actual);
					list.add(actualDetail);
				}
			}
			actual.setActualDetailCollection(list);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actual;
	}
}
