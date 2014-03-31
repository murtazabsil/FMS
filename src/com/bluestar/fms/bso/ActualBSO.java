package com.bluestar.fms.bso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.vo.ActualVO;

public interface ActualBSO {

	List<ActualVO> getActualList(HttpServletRequest request);

	ActualVO getActualDetails(Long actualId);

	void addActual(HttpServletRequest request);

	boolean getIsActual(Long forecastId);

	Long getActualIdFromForecast(Long forecastId);

}
