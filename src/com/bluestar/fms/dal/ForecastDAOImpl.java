package com.bluestar.fms.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.util.ConfigReader;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ForecastVO;
import com.fms.dao.ConnectionManager;
import com.fms.dao.DAOManager;

public class ForecastDAOImpl implements ForecastDAO {

	@Override
	public Month getMonthById(Integer monthId) {
		// TODO Auto-generated method stub
		Month month = null;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			month = daoManager.find(monthId, "Month");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return month;
	}

	@Override
	public Forecast addForecast(Forecast forecast) {
		Session session = null;
		Transaction transaction = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			transaction = session.getTransaction();
			transaction.begin();
			daoManager.create(forecast);
			transaction.commit();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecast;
	}

	@Override
	public List<ForecastVO> getForecastList(Long projectId) {
		// TODO Auto-generated method stub
		List<ForecastVO> forecastVOs = null;
		Session session = null;
		Transaction transaction = null;
		DAOManager daoManager = null;
		try {
			forecastVOs = new ArrayList<ForecastVO>();
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			transaction = session.beginTransaction();
			Query forecastListQuery = session
					.createQuery("SELECT f FROM Forecast f where projectId=:projectId");
			forecastListQuery.setLong("projectId", projectId);
			List<Forecast> forecasts = forecastListQuery.list();
			for (Forecast forecast : forecasts) {
				forecastVOs.add(ForecastUtil
						.getForecastVOFromForecast(forecast));
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return forecastVOs;
	}

	@Override
	public Project getProjectById(Long projectId) {
		// TODO Auto-generated method stub
		Project project = null;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			project = daoManager.find(projectId, "Project");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return project;
	}

	@Override
	public Manager getManagerById(Long managerId) {
		// TODO Auto-generated method stub
		Manager manager = null;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			manager = daoManager.find(managerId, "Manager");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return manager;
	}

}
