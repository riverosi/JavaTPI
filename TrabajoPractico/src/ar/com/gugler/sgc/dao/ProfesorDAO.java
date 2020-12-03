package ar.com.gugler.sgc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ar.com.gugler.sgc.modelo.Profesor;

/**
 * ProfesorDAO Class used for Data Access Object Software Pattern
 * 
 * @author Ignacio Riveros
 *
 */
public class ProfesorDAO extends GenericDAO<Profesor> {

	@Override
	public String getTable() {
		return "PROFESORES";
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO `tp`.`profesores` (`cuil`, `numeroDocumento`, `apellido`, `nombres`, `fechaNacimiento`, `domicilio`, `telefono`, `correoElectronico`, `fechaIngreso`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Profesor object) throws SQLException {
		preparedStatement.setString(1, object.getCuil());
		preparedStatement.setString(2, object.getNumeroDocumento());
		preparedStatement.setString(3, object.getApellido());
		preparedStatement.setString(4, object.getNombres());
		preparedStatement.setDate(5, new java.sql.Date(object.getFechaNacimiento().getTime()));
		preparedStatement.setString(6, object.getDomicilio());
		preparedStatement.setString(7, object.getTelefono());
		preparedStatement.setString(8, object.getCorreoElectronico());
		preparedStatement.setDate(9, new java.sql.Date(object.getFechaIngreso().getTime()));
	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE `tp`.`profesores` SET `cuil` = ?, `numeroDocumento` = ?, "
				+ "`apellido` = ?, `nombres` = ?, `fechaNacimiento` = ?, "
				+ "`domicilio` = ?, `telefono` = ?, `correoElectronico` = ?, `fechaIngreso` = ? " + "WHERE (`id` = ?) ";
	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Profesor object) throws SQLException {
		preparedStatement.setString(1, object.getCuil());
		preparedStatement.setString(2, object.getNumeroDocumento());
		preparedStatement.setString(3, object.getApellido());
		preparedStatement.setString(4, object.getNombres());
		preparedStatement.setDate(5, new java.sql.Date(object.getFechaNacimiento().getTime()));
		preparedStatement.setString(6, object.getDomicilio());
		preparedStatement.setString(7, object.getTelefono());
		preparedStatement.setString(8, object.getCorreoElectronico());
		preparedStatement.setDate(9, new java.sql.Date(object.getFechaIngreso().getTime()));
		preparedStatement.setLong(10, object.getId());
	}

	@Override
	protected Profesor populate(ResultSet rs) throws SQLException {
		Long id = rs.getLong(1);
		String cuil = rs.getString(2);
		String numeroDocumento = rs.getString(3);
		String apellido = rs.getString(4);
		String nombres = rs.getString(5);
		Date fechaNacimiento = rs.getDate(6);
		String domicilio = rs.getString(7);
		String telefono = rs.getString(8);
		String correoElectronico = rs.getString(9);
		Date fechaIngreso = rs.getDate(10);
		Profesor p = new Profesor(cuil, numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono,
				correoElectronico, fechaIngreso);
		p.setId(id);
		return p;
	}

}
