package ar.com.gugler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import ar.com.gugler.sgc.modelo.Alumno;


public class AlumnoDAO extends BaseDAO<Alumno> {

	@Override
	public void insert(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sqlInsert = "INSERT INTO `tp`.`alumnos` (`numeroDocumento`, `nombres`, `apellido`, `legajo`) VALUES (?,?,?,?);";
		try {
			pstmt = con.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1 , alumno.getNumeroDocumento());
			pstmt.setString(2 , alumno.getNombres());
			pstmt.setString(3 , alumno.getApellido());
			pstmt.setString(4 , alumno.getLegajo());
			pstmt.executeUpdate();
			res = pstmt.getGeneratedKeys();
			while (res.next()) {
				alumno.setId(res.getLong(1));
		      }
			System.out.println("Successful data Insert.");
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error insert Alumno data.");
			e.printStackTrace();
		} 		
	}

	@Override
	public void delete(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlDelete = "DELETE FROM `tp`.`alumnos` WHERE (`idAlumnos` = ?)";
		try {
			pstmt = con.prepareStatement(sqlDelete);
			pstmt.setLong(1, alumno.getId());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Successful Deleting Alumno.");
		} catch (SQLException e) {
			System.err.println("Error Deleting Alumno.");
			e.printStackTrace();
		} 		
	}

	@Override
	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlUpdate = "UPDATE `tp`.`alumnos` SET `numeroDocumento` = ?, `nombres` = ?, `apellido` = ?, `legajo` = ?"
				+ " WHERE (`idAlumnos` = ?);";
		try {
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1 , alumno.getNumeroDocumento());
			pstmt.setString(2 , alumno.getNombres());
			pstmt.setString(3 , alumno.getApellido());
			pstmt.setString(4 , alumno.getLegajo());
			pstmt.setLong(5, alumno.getId());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Successful Update of Alumno data.");
		} catch (SQLException e) {
			System.err.println("Error Updating Alumno");
			e.printStackTrace();
		}
	}

	@Override
	public List<Alumno> getAll() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet res = null;
		var listaAlumnos = new ArrayList<Alumno>();
		String sqlGetAll = "SELECT * FROM tp.alumnos;";
		try {
			pstmt = con.prepareStatement(sqlGetAll);
			res = pstmt.executeQuery();
			while (res.next()) {
				var auxAlumno = new Alumno(res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				auxAlumno.setId(res.getLong(1));
				listaAlumnos.add(auxAlumno);
		      }
			System.out.println("Successful Get All Rows.");
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error Get All.");
			e.printStackTrace();
		} 	
		return listaAlumnos;
	}



}
