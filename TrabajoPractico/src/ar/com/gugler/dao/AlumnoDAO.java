package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ar.com.gugler.sgc.modelo.Alumno;

public class AlumnoDAO extends GenericDAO<Alumno> {

	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return "ALUMNOS";
	}

	@Override
	protected String getInsertSql() {
		// TODO Auto-generated method stub
		return "INSERT INTO `tp`.`alumnos` (`numeroDocumento`, `apellido`, `nombres`, `fechaNacimiento`, `domicilio`, `telefono`, `correoElectronico`, `legajo`) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Alumno object) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement.setString(1, object.getNumeroDocumento());
		preparedStatement.setString(2, object.getApellido());
		preparedStatement.setString(3, object.getNombres());
		preparedStatement.setDate(4, new java.sql.Date(object.getFechaNacimiento().getTime()));
		preparedStatement.setString(5, object.getDomicilio());
		preparedStatement.setString(6, object.getTelefono());
		preparedStatement.setString(7, object.getCorreoElectronico());
		preparedStatement.setString(8, object.getLegajo());

	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Alumno object) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement.setString(1, object.getNumeroDocumento());
		preparedStatement.setString(2, object.getApellido());
		preparedStatement.setString(3, object.getNombres());
		preparedStatement.setDate(4, new java.sql.Date(object.getFechaNacimiento().getTime()));
		preparedStatement.setString(5, object.getDomicilio());
		preparedStatement.setString(6, object.getTelefono());
		preparedStatement.setString(7, object.getCorreoElectronico());
		preparedStatement.setString(8, object.getLegajo());
		preparedStatement.setLong(9, object.getId());
	}

	@Override
	protected String getUpdateSql() {
		// TODO Auto-generated method stub
		return "UPDATE `tp`.`alumnos` SET `numeroDocumento` = ?, `apellido` = ?, `nombres` = ?, `fechaNacimiento` = ?, `domicilio` = ?, `telefono` = ?, `correoElectronico` = ?, `legajo` = ? "
				+ "WHERE (`id` = ?) ";
	}

	@Override
	protected Alumno populate(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Long id = rs.getLong(1);
		String numeroDocumento = rs.getString(2);
		String apellido = rs.getString(3);
		String nombres = rs.getString(4);
		Date fechaNacimiento = rs.getDate(5);
		String domicilio = rs.getString(6);
		String telefono = rs.getString(7);
		String correoElectronico = rs.getString(8);
		String legajo = rs.getString(9);
		var a = new Alumno(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico,
				legajo);
		a.setId(id);
		return a;
	}

}
