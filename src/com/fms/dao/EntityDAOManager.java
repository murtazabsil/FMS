package com.fms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yogeshkumar.vaghela
 */
public class EntityDAOManager<T> {
     
    @SuppressWarnings("unused")
	private Class<T> entityClass;
    private String className = "";
    private SessionFactory sf = null;

    /**
     * This method will set Entity and Create EntityManager from connectionContext
     * @param entityClass
     * @param connectionContext 
     */
    public EntityDAOManager(Class<T> entityClass, String connStr) {
    	debugLogger("DAOManager constructor start, entityClass="+entityClass+",connStr="+connStr);
    	this.entityClass = entityClass;
    	debugLogger("Getting session factory for given connStr="+connStr);
    	
    	if(sf == null){
    		this.sf =  ConnectionManager.getSessionFactory(connStr);	
    	}
        
        if(entityClass != null){
        	String name =entityClass.getName(); 
        	debugLogger("Class name = "+name);
	    	if(name.lastIndexOf('.')>0){
	    		className = name.substring(name.lastIndexOf('.')+1);
	    	}
        }
        debugLogger("className= "+className);
    }
    
    private SessionFactory getSessionFactory(){
        return this.sf;
    }
    
    private String getClassName(){
    	return this.className;
    }
    
    private Session getSession(){
    	debugLogger("Getting session.");
    	if(getSessionFactory() != null){
    		return sf.openSession();	
//    		return sf.getCurrentSession();
    	}else{
    		return null;
    	}
    }

    
    private void closeSession(Session session){
    	debugLogger("Closing session.");
    	if(session != null){
    		if(session.isOpen()){
    			session.close();
    		}
    		session = null;
    	}
    }
    
    @SuppressWarnings("unchecked")
	public T create(T entity) {
        debugLogger("Adding new "+getClassName()+" start");
        Session session = getSession();
        
        if(entity != null){
	        try {
				session.beginTransaction().begin();
				entity = (T) session.save(entity);
				session.beginTransaction().commit();
				debugLogger("New "+getClassName()+" has been added successfully");
				
	        } catch (HibernateException e) {
	        	//if error occured, set error code and error message into entity
	        	//log.error(e);
	        	debugLogger("Hibernate error occured while adding new "+getClassName()+".");
	        	e.printStackTrace();//remove this when logger implemented
			} catch(Exception e){
	        	//if error occured, set error code and error message into entity
	        	//log.error(e);
	        	debugLogger("Error occured while Adding new "+getClassName()+".");
	        	e.printStackTrace();//remove this when logger implemented
			}finally {
				closeSession(session);
			}
        }
        
        return entity;
    }

    @SuppressWarnings("unchecked")
	public T edit(T entity) {
    	debugLogger("Edit "+getClassName()+" start");
    	Session session = getSession();
        try {
			session.beginTransaction().begin();
			entity = (T) session.merge(entity);
			session.beginTransaction().commit();
			debugLogger(""+getClassName()+" has been updated successfully");
        } catch (HibernateException e) {
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Hibernate error occured while editing "+getClassName()+".");
        	e.printStackTrace();//remove this when log.error 
		}catch(Exception e){
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Error occured while Editing "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}finally {
			closeSession(session);
		}
        return entity;
    }


    public int remove(Object id) {
	
		debugLogger("Delete "+getClassName()+" start");
		Session session = getSession();
    
		int rowsDeleted = -1;
		
        try {
			
			session.beginTransaction().begin();
			debugLogger("Entity check for delete");
			Query query = session.createQuery("delete from "+getClassName()+" where id=:param");
			query.setParameter("param", id);
			rowsDeleted = query.executeUpdate();
			
			if(rowsDeleted <= 0){
				debugLogger(getClassName()+" not deleted or not exist to delete");
				//Add message code and message into entity
			}else{
				debugLogger(getClassName()+" has been deleted successfully");
				//Add message code and message into entity
			}
			session.beginTransaction().commit();
			
        } catch (HibernateException e) {
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Hibernate error occured while removing "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}catch(Exception e){
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Error occured while removing "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}finally {
			closeSession(session);
		}
        return rowsDeleted;
    }
    

	@SuppressWarnings("unchecked")
    public T find(Object id) {
    	T obj = null;
    	debugLogger("Find by id for "+getClassName()+" start");
        try {
        	Session session = getSession();

        	Query query = session.createQuery("from "+getClassName()+" where id=:param");
        	query.setParameter("param",id);
        	
			List<T> objList = (List<T>)query.list();

        	debugLogger("Checking is result found?");
        	
        	if(objList != null && !objList.isEmpty()){
        		debugLogger("Search result found");
        		obj = (T) objList.get(0);
        	}else{
        		debugLogger("Search result not found");
        	}
        } catch (HibernateException e) {
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Hibernate error occured while finding "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}catch(Exception e){
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Error occured while finding "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}
        return obj;
    }

    
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	List<T> objList = null;
    	Session session = getSession();
    	
    	debugLogger("Find all "+getClassName()+" start");
        try {
        	if(session != null){
            	Query query = session.createQuery("from "+getClassName());
            	objList = query.list();
        	}
        } catch (HibernateException e) {
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Hibernate error occured while finding all "+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		
        }catch(Exception e){
        	//if error occured, set error code and error message into entity
        	//log.error(e);
        	debugLogger("Error occured while finding all"+getClassName()+".");
        	e.printStackTrace();//remove this when logger implemented
		}
        return objList;
    }

    @SuppressWarnings("unchecked")
	public int count() {
        debugLogger("count start");
        Session session = getSession();

        int count = -1;
       
        try {
			if (session != null) {
				session.beginTransaction().begin();
				Query q = session.createQuery("from "
						+ this.className.toString() + " s");
				List<T> entityList = (List<T>) q.list();
				session.beginTransaction().commit();
				if (entityList != null) {
					count = entityList.size();
					debugLogger("count=" + count);
				} else {
					debugLogger("entityList is null");
				}
			} else {
				debugLogger("Session is null");
			}
		} catch (Exception e) {
			e.printStackTrace();//add log.error
		}finally {
			closeSession(session);
		}
        
		return count;
    }
    
    public static void debugLogger(String loggerString){
//      log.debug string
        System.out.println("### DAOManager:"+loggerString);
    }
    
      
    
}
