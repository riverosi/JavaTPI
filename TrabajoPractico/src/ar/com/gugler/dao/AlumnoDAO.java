package ar.com.gugler.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ar.com.gugler.sgc.modelo.Alumno;

public class AlumnoDAO extends BaseDAO<Alumno> {

	@Override
	public void insert(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		String sqlQuery = "INSERT INTO tp (numeroDocumento, apellido, nombres)"
				+ "VALUES ("
				+ alumno.getNumeroDocumento()
				+ alumno.getApellido()
				+ alumno.getNombres()
				+");";
		try {
			
			con = DriverManager.getConnection( URL , USER , PASSWORD );
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlQuery);
			
		} catch (SQLException e) {
			System.out.println("Error in conection");
			e.printStackTrace();
			
		} finally {
			
			try {
				if (rset != null) {rset.close();}
				if (stmt != null) {stmt.close();}
				if (con != null ) {con.close();}				
			} catch (SQLException e2) {
				System.out.println("Error in close conection");
				e2.printStackTrace();
			}
			
			
		}
		

	}

	@Override
	public void delete(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alumno> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
