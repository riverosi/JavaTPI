package ar.com.gugler.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static Connection instance;
	private java.sql.Connection con;

	protected String DRIVER = "com.mysql.jdbc.Driver";
	protected String URL = "jdbc:mysql://localhost/tp?useSSL=false";
	protected String USER = "root";
	protected String PASSWORD = "simplementememoria";

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

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	public java.sql.Connection getConnection() {
		return this.con;
	}

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
