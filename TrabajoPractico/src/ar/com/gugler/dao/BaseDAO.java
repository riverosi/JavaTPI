package ar.com.gugler.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;


public abstract class BaseDAO <T extends BaseModelo> {
	
	protected Connection con;
	
	protected String DRIVER = "com.mysql.jdbc.Driver";
	protected String URL = "jdbc:mysql://localhost/tp?useSSL=false";
	protected String USER = "root";
	protected String PASSWORD = "simplementememoria";
	
	
	public void connect() {
	
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection( URL , USER , PASSWORD );
			System.out.println("Successful Connection.");
			
		} catch (ClassNotFoundException e) {
			
			System.err.println("Error in Driver connection to data base.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.err.println("Error in conection.");
			e.printStackTrace();
			
		}
		
	
	}
	
	
	public void closeConnection() {
		
		try {
			
				con.close();
				System.out.println("Successful Disconnection.");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.err.println("Error clousing the conection whit data base.");
				
			}
	}
	
	public abstract void insert(T b) throws SQLException;
	
	public abstract void delete(T b) throws SQLException;
	
	public abstract void update(T b);
	
	public abstract List<T> getAll() throws SQLException;
}
