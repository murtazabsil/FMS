package com.bluestar.fms.bso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.vo.ForecastVO;

public interface ForecastBSO {

	public void addForecast(HttpServletRequest request);
	public Month getMonthById(Integer monthId);
	public List<ForecastVO> getForecastList(HttpServletRequest request); 
	public Project getProjectById(Long projectId);
	public Manager getManagerById(Long managerId);
}
