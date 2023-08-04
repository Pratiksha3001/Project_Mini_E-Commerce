package com.db.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class myDbConnection {
	
 static Connection connection=null;
 
	public static Connection getConnectionDetails() {
		
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom","root","Amar@3001");
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return connection;
		
		
		 
		
		
	}
}
