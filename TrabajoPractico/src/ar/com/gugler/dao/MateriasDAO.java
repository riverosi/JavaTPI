package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.com.gugler.sgc.modelo.Alumno;
import ar.com.gugler.sgc.modelo.Materia;

public class MateriasDAO extends GenericDAO<Materia> {

	@Override
	public String getTable() {
		return "MATERIAS";
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO `tp`.`materias` (`codigo`, `nombre`, `id_profesor`, `anio`) VALUES (?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Materia object) throws SQLException {
		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setLong(3, object.getProfesor().getId());
		preparedStatement.setInt(4, object.getAnio());
	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Materia object) throws SQLException {
		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setLong(3, object.getProfesor().getId());
		preparedStatement.setInt(4, object.getAnio());	
		preparedStatement.setLong(5, object.getId());
		
	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE `tp`.`materias` SET `codigo` = ?, `nombre` = ?, `id_profesor` = ?, `anio` = ? WHERE (`idMaterias` = ?) ";
	}

	@Override
	protected Materia populate(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Long id = rs.getLong(1);
		Integer codigo = rs.getInt(2);
		String nombre = rs.getString(3);
		Long id_profesor = rs.getLong(4);
		Integer anio = rs.getInt(5);
		var m = new Materia(codigo, nombre, id_profesor, anio);
		m.setId(id);
		return m;
	}

	@Override
	protected String getDeleteSql() {
		return "DELETE FROM `tp`.`materias` WHERE (`idMaterias` = ?) ";
	}
	
}