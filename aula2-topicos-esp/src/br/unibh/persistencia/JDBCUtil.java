package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
	private static Connection conn;
	
	public static Connection getConnection() throws Exception{
		if(conn == null || conn.isClosed()){
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8000/unibh", "unibh", "1234");
		}
		return conn;
	}
	
	public static void closeConnection() throws Exception{
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}

}