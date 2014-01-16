package com.eResorts;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnPool {
	   private DataSource dataSource;
	   private Connection connection;

	public void init() throws ServletException {
        try {
            // Get DataSource
            Context initContext  = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/ezest");
 
             
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
	
	public  Connection getConnection(){
		try {
			connection = dataSource.getConnection();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
}
