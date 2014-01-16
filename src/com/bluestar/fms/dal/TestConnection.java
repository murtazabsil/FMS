package com.bluestar.fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
		con = com.eResorts.ConnectionPool.getConnection();
		
			stmt =  con.prepareStatement(" select 1 ");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
