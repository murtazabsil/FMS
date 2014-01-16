package com.fms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bluestar.fms.util.ConfigReader;

/**
 * 
 * @author pankaj.amal
 */
public class ConnectionManager{

    private static Map<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
    
    private static ArrayList<Session> sessionData = new ArrayList<Session>();

    public static Session getSession(String connStr) {
        debugLogger("getSession start");
        Session session = null;
        try {
        	if(sessionData.size() > 0){
        		debugLogger("Getting Session From Existing Data");
        		session = sessionData.get(0);
        	} else {
        		 debugLogger("Creating New Session");
        		 SessionFactory sessionFactory = new AnnotationConfiguration().configure(connStr).buildSessionFactory();
        		 session = sessionFactory.openSession();
        		 sessionData.add(session);
        	}
        } catch (Exception e) {
            e.printStackTrace();// remove this when logger implemented
        }
        return session;
    }
    
    @SuppressWarnings("null")
    public static SessionFactory getSessionFactory(String connStr) {
        debugLogger("getSessionFactory start, connStr=" + connStr);

        boolean isConnAvailable = false;
        SessionFactory sessionFactory = null;

        try {
            if (connStr != null || !connStr.equals("")) {
                if (sessionFactoryMap != null && !sessionFactoryMap.isEmpty()) {
                    isConnAvailable = sessionFactoryMap.containsKey(connStr);
                }

                if (isConnAvailable == false) {
                    sessionFactory=  loadFactory(connStr);
                    
                } else {
                    debugLogger("SessionFactory for given " + connStr + " exist and returning it.");
                    sessionFactory = sessionFactoryMap.get(connStr);
                }
            }
        } catch (Exception e) {
            // log.error
            e.printStackTrace();// remove this when logger implemented
        }

        return sessionFactory;
    }

    /**
     * @param connStr
     */
    private static synchronized SessionFactory loadFactory(String connStr) {
        SessionFactory sessionFactory = null;
        try {
            if (sessionFactoryMap != null && !sessionFactoryMap.isEmpty() && sessionFactoryMap.containsKey(connStr)) {
                sessionFactory = sessionFactoryMap.get(connStr);
                return sessionFactory;
            } else {
                System.out.println("In loadFactory ************** :" + connStr);

                debugLogger("Creating new factory for given connStr=" + connStr);
                 sessionFactory = new AnnotationConfiguration().configure(connStr).buildSessionFactory();
                if (sessionFactory != null) {
                    debugLogger("SessionFactory created successfully for connStr=" + connStr);
                    sessionFactoryMap.put(connStr, sessionFactory);
                } else {
                    debugLogger("Unable to create sessionFactory for given connStr=" + connStr);
                }
            }

        } catch (Exception e) {
            System.out.println("Exception in loadFactory ************** :" + e);
        }

        return sessionFactory;
    }

    /*public static Session getSession(String connStr) {
        debugLogger("getSession start for given connStr=" + connStr);
        Session session = null;
        try {
            SessionFactory sessionFactory = getSessionFactory(connStr);
            if (sessionFactory != null) {
                if (session == null) {
                    session = sessionFactory.openSession();
                    System.out.println("In getSession Created New Session :" + connStr);
                } else if(!session.isOpen()) {
                        session = sessionFactory.openSession();
                        System.out.println("In getSession Existing Session :" + connStr);
                    } else {
                        System.out.println("In getSession Thread Local Session :" + connStr);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();// remove this when logger implemented
        }
        return session;
    }*/

    public static Session getNewSession(String connStr) {
        debugLogger("getSession start for given connStr=" + connStr);
        Session session = null;
        try {
            SessionFactory sessionFactory = getSessionFactory(connStr);
            if (sessionFactory != null) {
                if (session == null) {
                    session = sessionFactory.openSession();
                    System.out.println("In getNewSession Created New Session :" + connStr);
                }
				else {
				    session = sessionFactory.openSession();
				    System.out.println("In getNewSession Created New Session :" + connStr);
				}
            }
        } catch (Exception e) {
            e.printStackTrace();// remove this when logger implemented
        }
        return session;
    }

    private static void debugLogger(String loggerString) {
        // log.debug string
        System.out.println("### ConnectionManager:" + loggerString);
    }

    private static void validateConnection(Session session, String connStr) {

        try {
            if (session != null) {
                Query query = session.createSQLQuery("SELECT 1");
                query.list();
                session.flush();
            } else {
                System.out.println("Session null in validateConnection :");
            }

        } catch (Exception e) {
            System.out.println("Exception in validateConnection ****************:" + e);

        }
    }
}