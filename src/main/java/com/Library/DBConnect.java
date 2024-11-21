
package com.Library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	// Define the database connection parameters	
	private static String url = "jdbc:mysql://localhost:3306/hertz_music_store";
	private static String userName = "root";
	private static String password = "Ik2001";
	
	private static Connection con;

	 // Establish a database connection
	public static Connection getConnection() {
		
		try {
			
	  // Load the MySQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
	  // Create a connection to the database using the provided URL, username, and password
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
	  // Return the established database connection
		return con;
	}
}
