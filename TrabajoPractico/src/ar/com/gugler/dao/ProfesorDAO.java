package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ar.com.gugler.sgc.modelo.Profesor;

public class ProfesorDAO extends BaseDAO<Profesor> {

	@Override
	public void insert(Profesor profesor) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sqlInsert = "INSERT INTO `tp`.`profesores` (`numeroDocumento`, `nombres`, `apellido`, `cuil`) VALUES (?,?,?,?);";
		try {
			pstmt = con.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1 , profesor.getNumeroDocumento());
			pstmt.setString(2 , profesor.getNombres());
			pstmt.setString(3 , profesor.getApellido());
			pstmt.setString(4 , profesor.getCuil());
			pstmt.executeUpdate();
			res = pstmt.getGeneratedKeys();
			while (res.next()) {
				profesor.setId(res.getLong(1));
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
	public void delete(Profesor profesor) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlDelete = "DELETE FROM `tp`.`profesores` WHERE (`idProfesores` = ?)";
		try {
			pstmt = con.prepareStatement(sqlDelete);
			pstmt.setLong(1, profesor.getId());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Successful Deleting Profesor.");
		} catch (SQLException e) {
			System.err.println("Error Deleting Profesor.");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Profesor profesor) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlUpdate = "UPDATE `tp`.`profesores` SET `numeroDocumento` = ?, `nombres` = ?, `apellido` = ?, `cuil` = ?"
				+ " WHERE (`idProfesores` = ?);";
		try {
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1 , profesor.getNumeroDocumento());
			pstmt.setString(2 , profesor.getNombres());
			pstmt.setString(3 , profesor.getApellido());
			pstmt.setString(4 , profesor.getCuil());
			pstmt.setLong(5, profesor.getId());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Successful Update of Profesor data.");
		} catch (SQLException e) {
			System.err.println("Error Updating Profesor.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Profesor> getAll() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		var listaProfesores = new ArrayList<Profesor>();
		String sqlGetAll = "SELECT * FROM tp.profesores;";
		try {
			pstmt = con.prepareStatement(sqlGetAll);
			res = pstmt.executeQuery();
			while (res.next()) {
				var auxProfesor = new Profesor(res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				auxProfesor.setId(res.getLong(1));
				listaProfesores.add(auxProfesor);
		      }
			System.out.println("Successful Get All Rows.");
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error Get All.");
			e.printStackTrace();
		} 	
		return listaProfesores;
	}

}
