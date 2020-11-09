package ar.com.gugler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import ar.com.gugler.sgc.modelo.Alumno;

public class AlumnoDAO extends BaseDAO<Alumno> {

	@Override
	public void insert(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlInsert = "INSERT INTO `tp`.`alumnos` (`numeroDocumento`, `apellido`, `nombres`) VALUES (?,?,?);";
		try {
			pstmt = con.prepareStatement(sqlInsert);
			pstmt.setString(1 , alumno.getNumeroDocumento());
			pstmt.setString(2 , alumno.getApellido());
			pstmt.setString(3 , alumno.getNombres());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error insert Alumno");
			e.printStackTrace();
		} 		
	}

	@Override
	public void delete(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		/**
		 * Buscamos si el alumno esta en la DB
		 */
		String sqlQuery = "SELECT * FROM Customers WHERE numeroDocumento = '" + alumno.getNumeroDocumento() + "';)";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlQuery);
			stmt.close();
			rset.close();
		} catch (SQLException e) {
			System.out.println("Error selecting Alumno");
			e.printStackTrace();
		}
		/**
		 * Eliminamos al alumno por el id
		 */
		PreparedStatement pstmt = null;
		String sqlDelete = "DELETE FROM `tp`.`alumnos` WHERE (`idAlumnos` = ?)";
		try {
			pstmt = con.prepareStatement(sqlDelete);
			pstmt.setLong(1, alumno.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error delete Alumno");
			e.printStackTrace();
		} 		
	}

	@Override
	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlUpdate = "UPDATE `tp`.`alumnos` SET `numeroDocumento` = ? WHERE (`idAlumnos` = '2');";
		try {
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1 , alumno.getNumeroDocumento());
			pstmt.setString(2, alumno.getApellido());
			pstmt.setString(3, alumno.getNombres());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error insert Alumno");
			e.printStackTrace();
		}
	}

	@Override
	public List<Alumno> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}



}
