package ar.com.gugler.sgc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.com.gugler.sgc.modelo.Curso;
import ar.com.gugler.sgc.modelo.Profesor;

/**
 * CursoDAO Class used for Data Access Object Software Pattern
 * 
 * @author Ignacio Riveros
 *
 */
public class CursoDAO extends GenericDAO<Curso> {

	@Override
	protected String getTable() {
		return "CURSOS";
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO `tp`.`cursos` (`codigo`, `nombre`, `id_profesor`, `cupo`) VALUES (?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Curso object) throws SQLException {
		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setLong(3, object.getProfesor().getId());
		preparedStatement.setInt(4, object.getCupo());

	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Curso object) throws SQLException {
		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setLong(3, object.getProfesor().getId());
		preparedStatement.setInt(4, object.getCupo());
		preparedStatement.setLong(5, object.getId());
	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE `tp`.`cursos` SET `nombre` = ?, `id_profesor` = ?, `curso` = ? WHERE (`id` = ?) ";
	}

	@Override
	protected Curso populate(ResultSet rs) throws SQLException {
		Long id = rs.getLong(1);
		Integer codigo = rs.getInt(2);
		String nombre = rs.getString(3);
		Long id_profesor = rs.getLong(4);
		Integer cupo = rs.getInt(5);
		var profesor = new Profesor("0", "0", "0");
		profesor.setId(id_profesor);
		var c = new Curso(codigo, nombre, profesor, cupo);
		c.setId(id);
		return c;
	}

	@Override
	public boolean insert(Curso object) throws SQLException {
		var result = super.insert(object);
		java.sql.Connection connection = Connection.getInstance().getConnection();
		var stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery("SELECT MAX(id) FROM cursos");
		res.next();
		var cursoId = res.getLong(1);
		for (var alumno : object.getAlumnos()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO `tp`.`alumnos_cursos` (`idAlumno`, `idCurso`) VALUES (?,?) ");
			preparedStatement.setLong(1, alumno.getId());
			preparedStatement.setLong(2, cursoId);
			preparedStatement.execute();
		}
		return result;
	}

	@Override
	public Curso get(Long id) throws SQLException {
		var curso = super.get(id);
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT alumnos_cursos.idAlumno FROM alumnos_cursos WHERE idCurso=? ");
		preparedStatement.setLong(1, curso.getId());
		ResultSet rs = preparedStatement.executeQuery();
		AlumnoDAO alumnoDao = new AlumnoDAO();
		while (rs.next()) {
			var idAlumno = rs.getLong(1);
			var alumno = alumnoDao.get(idAlumno);
			curso.agregarAlumno(alumno);
		}
		return curso;
	}

	@Override
	public List<Curso> getAll() throws SQLException {
		var cursos = super.getAll();
		java.sql.Connection connection = Connection.getInstance().getConnection();
		for (Curso curso : cursos) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT alumnos_cursos.idAlumno FROM alumnos_cursos WHERE idCurso=? ");
			preparedStatement.setLong(1, curso.getId());
			ResultSet rs = preparedStatement.executeQuery();
			AlumnoDAO alumnoDao = new AlumnoDAO();
			while (rs.next()) {
				var idAlumno = rs.getLong(1);
				var alumno = alumnoDao.get(idAlumno);
				curso.agregarAlumno(alumno);
			}
		}
		return cursos;
	}

	@Override
	public int delete(Curso object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from tp.alumnos_cursos where idCurso = ? ");
		preparedStatement.setLong(1, object.getId());
		preparedStatement.executeUpdate();
		return super.delete(object);
	}
}
