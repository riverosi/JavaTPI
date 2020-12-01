/**
 * @author Ignacio Riveros
 * @version 1.0
 */
package ar.com.gugler.sgc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;




public class Connection {
	/**
	 * Attributes
	 */
	private static Connection instance;
	private java.sql.Connection con;
	/* Driver attributes change parameters for connect to data base */
	final protected String DRIVER = "com.mysql.jdbc.Driver";
	final protected String URL = "jdbc:mysql://localhost/tp?useSSL=false";
	final protected String USER = "root";
	final protected String PASSWORD = "simplementememoria";

	/*
	 * Constructor
	 */
	private Connection() {
		try {
			Class.forName(DRIVER);
			this.con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Successful Connection.");
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Error in Driver connection to data base.");
			e.printStackTrace();
		}
	}

	/**
	 * function to connect with the database
	 * 
	 * @return unique instance of singleton factory
	 */
	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	/**
	 * function to get connection object
	 * 
	 * @return Connection object
	 */
	public java.sql.Connection getConnection() {
		return this.con;
	}

	/**
	 * function to close connection to data base
	 */
	public void closeConnection() {
		try {
			this.con.close();
			System.out.println("Successful Disconnection.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error clousing the conection whit data base.");
		}
	}
}
