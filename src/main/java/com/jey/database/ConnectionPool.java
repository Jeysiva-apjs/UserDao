package com.jey.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private static final String URL = "jdbc:mysql://localhost/mydb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	
	public ConnectionPool() {
		
		try {
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
