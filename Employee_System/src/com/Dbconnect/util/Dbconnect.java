package com.Dbconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {
	private static Connection connection;
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/employee";
			connection=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

					
		return connection;
		
	}

}


