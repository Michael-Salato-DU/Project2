package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	
	public static Connection conn = null;
	
	/**
	 * getConnection method
	 * @return A connection to the database
	 */
	public static Connection getConnection() {
		
		try {
			if (conn == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String endpoint = "jdbc:oracle:thin:@pbmd.clojiyi6uxgo.us-east-1.rds.amazonaws.com:1521:ORCL";
				String username = "max_effort";
				String password = "bads1234";
				
				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;
			} else {
				return conn;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}