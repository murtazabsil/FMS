package com.bluestar.fms.dal;

import java.util.List;

import com.bluestar.fms.entity.Actual;
import com.bluestar.fms.vo.ActualVO;

public interface ActualDAO {

	List<ActualVO> getActualList(Long projectId, Long forecastId);

	Actual getActualDetails(Long actualId);

	Actual addActual(Actual actual);

	boolean getIsActualPresent(Long forecastId);

	Long getActualIdFromForecast(Long forecastId);

}
