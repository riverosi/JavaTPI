package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.com.gugler.sgc.modelo.Alumno;
import ar.com.gugler.sgc.modelo.Materia;
import ar.com.gugler.sgc.modelo.Profesor;

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
		return "UPDATE `tp`.`materias` SET `codigo` = ?, `nombre` = ?, `id_profesor` = ?, `anio` = ? WHERE (`id` = ?) ";
	}

	@Override
	protected Materia populate(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Long id = rs.getLong(1);
		Integer codigo = rs.getInt(2);
		String nombre = rs.getString(3);
		Long id_profesor = rs.getLong(4);
		Integer anio = rs.getInt(5);
		var profesor = new Profesor("0", "0", "0");
		profesor.setId(id_profesor);
		var m = new Materia(codigo, nombre, profesor, anio);
		m.setId(id);
		return m;
	}

	@Override
	protected String getDeleteSql() {
		return "DELETE FROM `tp`.`materias` WHERE (`id` = ?) ";
	}

	@Override
	public boolean insert(Materia object) throws SQLException {
		var result = super.insert(object);
		java.sql.Connection connection = Connection.getInstance().getConnection();
		var stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery("SELECT MAX(id) FROM materias");
		res.next();
		var materiaId = res.getLong(1);
		for (var alumno : object.getAlumnos()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO `tp`.`alumnos_materias` (`idAlumno`, `idMaterias`) VALUES (?,?);");
			preparedStatement.setLong(1, alumno.getId());
			preparedStatement.setLong(2, materiaId);
			preparedStatement.execute();
		}
		return result;
	}

	@Override
	public Materia get(Long id) throws SQLException {
		var materia = super.get(id);
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT alumnos_materias.idAlumno FROM alumnos_materias WHERE idMaterias=? ");
		preparedStatement.setLong(1, materia.getId());
		ResultSet rs = preparedStatement.executeQuery();
		AlumnoDAO alumnoDao = new AlumnoDAO();
		while (rs.next()) {
			var idAlumno = rs.getLong(1);
			var alumno = alumnoDao.get(idAlumno);
			materia.getAlumnos().add(alumno);
		}
		return materia;
	}
	@Override
	public List<Materia> getAll() throws SQLException {
		var materias = super.getAll();
		java.sql.Connection connection = Connection.getInstance().getConnection();
		for (Materia materia : materias) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT alumnos_materias.idAlumno FROM alumnos_materias WHERE idMaterias=? ");
			preparedStatement.setLong(1, materia.getId());
			ResultSet rs = preparedStatement.executeQuery();
			AlumnoDAO alumnoDao = new AlumnoDAO();
			while (rs.next()) {
				var idAlumno = rs.getLong(1);
				var alumno = alumnoDao.get(idAlumno);
				materia.getAlumnos().add(alumno);
			}
		}
		return materias;
	}

}
