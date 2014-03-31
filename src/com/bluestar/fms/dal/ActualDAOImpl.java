package com.bluestar.fms.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.entity.Actual;
import com.bluestar.fms.entity.Forecast;
import com.bluestar.fms.util.ActualUtil;
import com.bluestar.fms.util.ConfigReader;
import com.bluestar.fms.util.ForecastUtil;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.ActualVO;
import com.bluestar.fms.vo.ForecastVO;
import com.fms.dao.ConnectionManager;
import com.fms.dao.DAOManager;

public class ActualDAOImpl implements ActualDAO {

	@Override
	public List<ActualVO> getActualList(Long projectId, Long forecastId) {
		// TODO Auto-generated method stub
		List<ActualVO> actualVOs = null;
		Session session = null;
		Transaction transaction = null;
		DAOManager daoManager = null;
		try {
			actualVOs = new ArrayList<ActualVO>();
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			transaction = session.beginTransaction();
			Query actualListQuery = null;
			if (forecastId == 0) {
				actualListQuery = session
						.createQuery("SELECT a FROM Actual a where projectId=:projectId");
				actualListQuery.setLong("projectId", projectId);
			} else {
				actualListQuery = session
						.createQuery("SELECT a FROM Actual a where projectId=:projectId AND forecastId=:forecastId");
				actualListQuery.setLong("projectId", projectId);
				actualListQuery.setLong("forecastId", forecastId);
			}
			List<Actual> actuals = actualListQuery.list();
			for (Actual actual : actuals) {
				actualVOs.add(ActualUtil.getActualVOFromEntity(actual));
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualVOs;
	}

	@Override
	public Actual getActualDetails(Long actualId) {
		// TODO Auto-generated method stub
		Actual actual = null;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			actual = daoManager.find(actualId, "Actual");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actual;
	}

	@Override
	public Actual addActual(Actual actual) {
		Session session = null;
		Transaction transaction = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			transaction = session.getTransaction();
			transaction.begin();
			daoManager.createOrUpdate(actual);
			transaction.commit();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actual;
	}

	@Override
	public boolean getIsActualPresent(Long forecastId) {
		// TODO Auto-generated method stub
		boolean isActualPresent = false;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			Query isActualQuery = session
					.createQuery("SELECT a FROM Actual a WHERE a.forecastId.forecastId=:forecastId");
			isActualQuery.setLong("forecastId", forecastId);
			if (isActualQuery.list().size() > 0) {
				isActualPresent = true;
			}
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return isActualPresent;
	}

	@Override
	public Long getActualIdFromForecast(Long forecastId) {
		// TODO Auto-generated method stub
		Long actualId = 0l;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query findActualQuery = session
					.createQuery("SELECT a FROM Actual a WHERE a.forecastId.forecastId=:forecastId");
			findActualQuery.setLong("forecastId", forecastId);
			Actual actual = (Actual) findActualQuery.list().get(0);
			actualId = actual.getActualId();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return actualId;
	}

}
