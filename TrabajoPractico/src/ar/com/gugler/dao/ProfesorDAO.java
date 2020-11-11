package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public void delete(Profesor b) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Profesor b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Profesor> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
