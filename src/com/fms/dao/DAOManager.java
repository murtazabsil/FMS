package com.fms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DAOManager {

	private Session session = null;

	@SuppressWarnings("unused")
	private DAOManager() {
	}

	public DAOManager(Session s) {
		if (s != null) {
			this.session = s;
		}
	}

	private Session getSession() {
		return this.session;
	}

	public void closeSession() {
		if (this.session != null) {
			if (this.session.isOpen()) {
				this.session.close();
			}
			session = null;
		}
	}

	public void beginTransaction() {
		if (this.session != null) {
			this.session.beginTransaction().begin();
		}
	}

	public void commitTransaction() {
		if (this.session != null) {
			this.session.flush();
			this.session.beginTransaction().commit();
		}
	}

	public void rollbackTransaction() {
		if (this.session != null) {
			this.session.beginTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T create(T entity) throws Exception {
		
		String className = getClassName(entity);
		debugLogger("Adding new " + className + " start");

		if (entity != null && getSession() != null) {
			try {
				entity = (T) getSession().save(entity);
				debugLogger("New " + className + " has been added successfully");

			} catch (HibernateException e) {
				// log.error(e);
				debugLogger("Hibernate error occured while adding new "
						+ className + ".");
				
				debugLogger("Exception:"+e);
				throw e;
				
			} catch (Exception e) {
				// log.error(e);
				debugLogger("Error occured while Adding new " + className + ".");
				debugLogger("Exception:"+e);
				throw e;
			} finally {
				// final code if required
			}
		}

		return entity;
	}


	
	public <T> T createOrUpdate(T entity) throws Exception {
		String className = getClassName(entity);

		if (entity != null && getSession() != null) {
			try {
				getSession().saveOrUpdate(entity);
				debugLogger("" + className + " has been added or updated successfully");

			} catch (HibernateException e) {
				// log.error(e);
				debugLogger("Hibernate error occured while adding new "
						+ className + ".");
				
				debugLogger("Exception:"+e);
				throw e;
			} catch (Exception e) {
				// log.error(e);
				debugLogger("Error occured while Adding new " + className + ".");
				debugLogger("Exception:"+e);
				throw e;
			} finally {
				// final code if required
			}
		}

		return entity;
	}

	
	
	public <T> int createOrUpdateAll(List<T> entityList) throws Exception {
		
		int inserted = -1;
		
		if(entityList != null){

			String className = getClassName(entityList.get(0));
			debugLogger("Adding or Updating all new " + className + " start");
			
			
			if (entityList != null && !entityList.isEmpty() && getSession() != null) {
				try {
					int count=0;
					for(T entity : entityList){
						inserted++;
						debugLogger("Inserting record:"+inserted+" ");
						getSession().saveOrUpdate(entity);
						
						debugLogger("New " + className + " has been added successfully");
						
//						if ( ++count % 20 == 0 ) {
//					        //flush a batch of updates and release memory:
//					        session.flush();
//					        session.clear();
//						}
					}

				} catch (HibernateException e) {
					// log.error(e);
					debugLogger("Hibernate error occured while adding new "
							+ className + ".");
					
					debugLogger("Exception:"+e);
					throw e;					

				} catch (Exception e) {
					// log.error(e);
					debugLogger("Error occured while Adding new " + className + ".");
					
					debugLogger("Exception:"+e);
					throw e;
				} finally {
					// final code if required
				}
			}
			
		}else{
			debugLogger("Null Entity cannot be processed.");
		}

		return inserted;
	}

	
//public <T> int createOrUpdateOrRemoveAll(Object id, List<T> entityList) throws Exception {
//		
//		int inserted = -1;
//		
//		if(entityList != null){
//
//			String className = getClassName(entityList.get(0));
//			debugLogger("Adding or Updating or remove all " + className + " start");
//			
//			
//			if (id != null && entityList != null && !entityList.isEmpty() && getSession() != null) {
//				try {
//					int count=0;
//					
//					//1. read all existings.
//					@SuppressWarnings({ "unused", "unchecked" })
//					List<T> existingEntityList = (List<T>) findAll(id, className);
//					if(existingEntityList != null && existingEntityList.isEmpty()){
//						
//						for(T entity : existingEntityList){
//							
//						}
//						
//						
//					}else{
//						//no existing found insert or update directly
//						debugLogger("Inserting record:"+inserted+" ");
//						getSession().saveOrUpdate(entity);
//					}
//					
//					
//					
//					for(T entity : entityList){
//						inserted++;
//
//						
//						
//						
//						debugLogger("New " + className + " has been added successfully");
//						
////						if ( ++count % 20 == 0 ) {
////					        //flush a batch of updates and release memory:
////					        session.flush();
////					        session.clear();
////						}
//					}
//
//				} catch (HibernateException e) {
//					// log.error(e);
//					debugLogger("Hibernate error occured while adding new "
//							+ className + ".");
//					
//					debugLogger("Exception:"+e);
//					throw e;					
//
//				} catch (Exception e) {
//					// log.error(e);
//					debugLogger("Error occured while Adding new " + className + ".");
//					
//					debugLogger("Exception:"+e);
//					throw e;
//				} finally {
//					// final code if required
//				}
//			}
//			
//		}else{
//			debugLogger("Null Entity cannot be processed.");
//		}
//
//		return inserted;
//	}

	
	@SuppressWarnings("unchecked")
	public <T> int createAll(List<T> entityList) throws Exception {
		
		String className = getClassName(entityList);
		debugLogger("Adding all new " + className + " start");
		
		int inserted = 0;
		
		if (entityList != null && !entityList.isEmpty() && getSession() != null) {
			try {
				int count=0;
				for(T entity : entityList){
					entity =  (T) getSession().save(entity);
					inserted++;
					debugLogger("New " + className + " has been added successfully");
					if ( ++count % 20 == 0 ) {
				        //flush a batch of updates and release memory:
				        session.flush();
				        session.clear();
					}
				}

			} catch (HibernateException e) {
				// log.error(e);
				debugLogger("Hibernate error occured while adding new "
						+ className + ".");
				debugLogger("Exception:"+e);
				throw e;
			} catch (Exception e) {
				// log.error(e);
				debugLogger("Error occured while Adding new " + className + ".");
				debugLogger("Exception:"+e);
				throw e;
			} finally {
				// final code if required
			}
		}

		return inserted;
	}

	
	
	
	@SuppressWarnings("unchecked")
	public <T> T edit(T entity) throws Exception {
		debugLogger("Edit " + getClassName(entity) + " start");
		try {
			if (getSession() != null) {
				entity = (T) getSession().merge(entity);
				debugLogger("Entity has been updated successfully");
			}

		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while editing Entity.");
			debugLogger("Exception:"+e);
			throw e;
		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while Editing Entity.");
			debugLogger("Exception:"+e);
			throw e;
		} finally {
			// finally code
		}
		return entity;
	}

	public int remove(Object id, String className) throws Exception {

		debugLogger("Delete Entity start");

		int rowsDeleted = -1;

		try {
			if (getSession() != null) {
				debugLogger("Entity check for delete");
				Query query = session.createQuery("delete from " + className
						+ " where id=:param");
				query.setParameter("param", id);
				rowsDeleted = query.executeUpdate();

				if (rowsDeleted <= 0) {
					debugLogger(className
							+ " not deleted or not exist to delete");
					// Add message code and message into entity
				} else {
					debugLogger(className + " has been deleted successfully");
					// Add message code and message into entity
				}
			}

		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while removing " + className
					+ ".");
			debugLogger("Exception:"+e);
			throw e;
		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while removing " + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		} finally {
			// finally code
		}
		return rowsDeleted;
	}

	@SuppressWarnings("unchecked")
	public <T> T find(Object id, String className) throws Exception {
		
		String methodName = "find:";
		
		T obj = null;
		debugLogger(methodName+"Find by id for " + className + " start");
		try {
			Session session = getSession();

			Query query = session.createQuery("from " + className
					+ " where id=:param");
			query.setParameter("param", id);

			query.setMaxResults(1);
			List<T> objList = (List<T>) query.list();

			debugLogger(methodName+"Checking is result found?");

			if (objList != null && !objList.isEmpty()) {
				debugLogger(methodName+"Search result found");
				obj = (T) objList.get(0);
			} else {
				debugLogger(methodName+"No record found");
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger(methodName+"Hibernate error occured while finding " + className
					+ ".");
			
			debugLogger("Exception:"+e);
			throw e;
			
		} catch (Exception e) {
			// log.error(e);
			debugLogger(methodName+"Error occured while finding " + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return obj;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Object id, String className) throws Exception {
		
		String methodName = "findAll:";
		
		List<T> objList = null;
		debugLogger(methodName+"FindAll by id for " + className + " start");
		try {
			Session session = getSession();

			Query query = session.createQuery("from " + className
					+ " where id=:param");
			query.setParameter("param", id);

			objList = (List<T>) query.list();

			debugLogger(methodName+"Checking is result found?");

			if (objList != null && !objList.isEmpty()) {
				debugLogger(methodName+"Search result found");
			} else {
				debugLogger(methodName+"No record found");
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger(methodName+"Hibernate error occured while finding " + className
					+ ".");
			
			debugLogger("Exception:"+e);
			throw e;
			
		} catch (Exception e) {
			// log.error(e);
			debugLogger(methodName+"Error occured while finding " + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findList(Object id, String parameterName, T entity) throws Exception {
		
		List<T> objList = null;
		String className = getClassName(entity);
		
		debugLogger("Find list by id for " + className + " start");
		try {
			Session session = getSession();

			Query query = session.createQuery("from " + className
					+ " where "+parameterName+ " =:param");
			query.setParameter("param", id);

			List<T> objList2 = (List<T>)query.list();
			objList = objList2;
			
			debugLogger("Checking is result found?");

			if (objList != null && !objList.isEmpty()) {
				debugLogger("Search result found");
			} else {
				debugLogger("Search result not found");
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while finding " + className
					+ ".");
			
			debugLogger("Exception:"+e);
			throw e;
			
		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding " + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}
	

	
	@SuppressWarnings("unchecked")
	public <T> List<T> findRangeByParam(Object id, String parameterName, T entity, Integer firstRecordNumber, Integer lastRecordNumber ) throws Exception {
		
		List<T> objList = null;
		String className = getClassName(entity);
		
		debugLogger("Find list by id for " + className + " start");
		try {
			Session session = getSession();

			Query query = session.createQuery("from " + className
					+ " where "+parameterName+ " =:param");
			query.setParameter("param", id);
			
			if(firstRecordNumber == null || firstRecordNumber <0){
				firstRecordNumber = 0;
			}
			
			if(lastRecordNumber == null || lastRecordNumber <=0){
				lastRecordNumber = 10;
			}
			
			query.setFirstResult(firstRecordNumber);
			query.setMaxResults(lastRecordNumber);

			List<T> objList2 = (List<T>)query.list();
			objList = objList2;
			
			debugLogger("Checking is result found?");

			if (objList != null && !objList.isEmpty()) {
				debugLogger("Search result found");
			} else {
				debugLogger("Search result not found");
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while finding " + className
					+ ".");
			debugLogger("Exception:"+e);
			throw e;
		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding " + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}

	
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(T entity) throws Exception {
		
		String methodName = "findAll";
		
		List<T> objList = null;
		Session session = getSession();
		String className = getClassName(entity);

		debugLogger(methodName+"Find all " + className + " start");
		try {
			if (session != null) {
				Query query = session.createQuery("from " + className);
				objList = query.list();
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger(methodName+"Hibernate error occured while finding all "
					+ className + ".");
			debugLogger("Exception:"+e);
			throw e;

		} catch (Exception e) {
			// log.error(e);
			debugLogger(methodName+"Error occured while finding all" + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}

	
	@SuppressWarnings("unchecked")
	public <T> List<T> findRange(Integer startRecord, Integer pagingSize, T entity) throws Exception {
		List<T> objList = null;
		Session session = getSession();
		String className = getClassName(entity);

		debugLogger("Find all range for " + className + " start");
		debugLogger("startRecord="+startRecord+", pagingSize="+pagingSize);
		
		if(startRecord == null || startRecord < 0 ){
			startRecord = 0;
		}
		
		if(pagingSize == null || pagingSize <= 0 ){
			pagingSize = DAOConstants.DEFAULT_PAGING_SIZE;
		}
		
		try {
			if (session != null) {
		
					Criteria criteria = session.createCriteria((entity).getClass());
					debugLogger("new startRecord="+startRecord+", pagingSize="+pagingSize);
					criteria.setFirstResult(startRecord);
					criteria.setMaxResults(pagingSize);
					objList = criteria.list();
					
					if(objList != null){
						debugLogger("objList="+objList.size());	
					}else{
						debugLogger("No result found for given page number and page size");
					}
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while finding range "
					+ className + ".");
			debugLogger("Exception:"+e);
			throw e;

		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding range" + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}
	
	/*@SuppressWarnings("unchecked")
	public <T> List<T> findRangeEnabledFalse(Integer startRecord, Integer pagingSize, T entity) throws Exception {
		List<T> objList = null;
		Session session = getSession();
		String className = getClassName(entity);

		debugLogger("Find all range for " + className + " start");
		debugLogger("startRecord="+startRecord+", pagingSize="+pagingSize);
		
		if(startRecord == null || startRecord < 0 ){
			startRecord = 0;
		}
		
		if(pagingSize == null || pagingSize <= 0 ){
			pagingSize = DAOConstants.DEFAULT_PAGING_SIZE;
		}
		
		debugLogger("startRecord="+startRecord+", pagingSize="+pagingSize);
		
		try {
			if (session != null) {
		
					Criteria criteria = session.createCriteria((entity).getClass());
					criteria.add(Restrictions.eq(DAOConstants.STR_ENABLED, false));
					criteria.setFirstResult(startRecord);
					criteria.setMaxResults(pagingSize);
					objList = criteria.list();
					
					if(objList != null){
						debugLogger("objList="+objList.size());	
					}else{
						debugLogger(DAOConstants.STR_NO_RESULT_FOUND);
					}
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while finding range "
					+ className + ".");
			debugLogger("Exception:"+e);
			throw e;

		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding range" + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}*/
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findRangeOfEnabled(Integer enabled, Integer startRecord, Integer pagingSize, T entity) throws Exception {
		List<T> objList = null;
		Session session = getSession();
		String className = getClassName(entity);

		debugLogger("Find all range for " + className + " start");
		debugLogger("startRecord="+startRecord+", pagingSize="+pagingSize);
		
		if(startRecord == null || startRecord < 0 ){
			startRecord = 0;
		}
		if(pagingSize == null || pagingSize <= 0 ){
			pagingSize = DAOConstants.DEFAULT_PAGING_SIZE;
		}
		
		boolean isEnabled = false;
		
		if(enabled != null){
			if(enabled == 1){
				isEnabled = true;
			}
		}
		
		try {
			if (session != null) {
		
					Criteria criteria = session.createCriteria((entity).getClass());
					criteria.add(Restrictions.eq("enabled", isEnabled));
					criteria.setFirstResult(startRecord);
					criteria.setMaxResults(pagingSize);
					objList = criteria.list();
					
					if(objList != null){
						debugLogger("objList="+objList.size());	
					}else{
						debugLogger("No result found for given page number and page size");
					}
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while finding range "
					+ className + ".");
			debugLogger("Exception:"+e);
			throw e;

		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding range" + className + ".");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public <T> Integer count(T entity) throws Exception {
		debugLogger("count start");

		Integer count = -1;

		try {
			if (getSession() != null) {
				debugLogger("Creating query for " + getClassName(entity));

				String queryStr = "from " + getClassName(entity) + " s";
				debugLogger("Query=" + queryStr);

				Query q = getSession().createQuery(queryStr);
				List<T> entityList = (List<T>) q.list();

				if (entityList != null) {
					count = entityList.size();
					debugLogger("count=" + count);
				} else {
					debugLogger("entityList is null");
				}
			} else {
				debugLogger("Session is null");
			}
			
		}catch(HibernateException e){
			debugLogger("Hibernate Error occured while getting count.");
			
			debugLogger("Exception:"+e);
			throw e;
			
		} catch (Exception e) {
			debugLogger("Error occured while getting count.");
			debugLogger(e.toString());
			throw e;
		} finally {
			// finally code
		}

		return count;
	}

	
	
	
	public <T> Long countLong(T entity) throws Exception {
		debugLogger("count start");

		Long count = -1L;

		try {
			if (getSession() != null) {
				String className = getClassName(entity);
				
				debugLogger("Creating query for " + className);

				
				String qString = "SELECT count(*) FROM " + className;
				Query query = session.createQuery(qString);
				//Query query = session.createSQLQuery(qString);
				 count = (Long) query.uniqueResult();
				
					debugLogger("count=" + count);
				
			} else {
				debugLogger("Session is null");
			}
			
		}catch(HibernateException e){
			debugLogger("Hibernate Error occured while getting count.");
			
			debugLogger("Exception:"+e);
			throw e;
			
		} catch (Exception e) {
			debugLogger("Error occured while getting count.");
			debugLogger(e.toString());
			throw e;
		} finally {
			// finally code
		}

		return count;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByQuery(String queryStr) throws Exception {
		List<T> objList = null;
		Session session = getSession();

		debugLogger("findByQuery start, queryStr=" + queryStr);

		try {
			if (session != null) {
				Query query = session.createQuery(queryStr);
				objList = query.list();
			}
		} catch (HibernateException e) {
			// log.error(e);
			debugLogger("Hibernate error occured while findByQuery.");
			debugLogger("Exception:"+e);
			throw e;

		} catch (Exception e) {
			// log.error(e);
			debugLogger("Error occured while finding findByQuery.");
			debugLogger("Exception:"+e);
			throw e;
		}
		return objList;
	}

	

	public <T> String getClassName(T entity) {
		String className = "";
		if (entity != null) {
			String name = ((T) entity).getClass().getName();
			debugLogger("Class name = " + name);
			if (name.lastIndexOf('.') > 0) {
				className = name.substring(name.lastIndexOf('.') + 1);
			}
		}
		return className;
	}

	private static void debugLogger(String loggerString) {
		// log.debug string
		System.out.println("### DAOManager:" + loggerString);
	}

}
