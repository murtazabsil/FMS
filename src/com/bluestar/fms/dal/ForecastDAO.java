package com.bluestar.fms.dal;

import java.util.List;

import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.vo.ForecastVO;

public interface ForecastDAO {

	public Forecast addForecast(Forecast forecast);
	public Month getMonthById(Integer monthId);
	public List<ForecastVO> getForecastList(Long projectId); 
	public Project getProjectById(Long projectId);
	public Manager getManagerById(Long managerId);
	public Forecast getForecastDetails(Long forecastId);
	public Forecast getForecastEntity(Long forecastId);
}
