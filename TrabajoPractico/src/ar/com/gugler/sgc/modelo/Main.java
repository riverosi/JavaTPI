package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;

import ar.com.gugler.dao.AlumnoDAO;


/**
 * Main Class
 * @author Riveros Ignacio
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		var alumno1 = new Alumno("39539138", "Skywalker", "Anakin");
		alumno1.setLegajo("12346");
		var alumno2 = new Alumno("39123456", "Skywalker", "Luke");
		alumno2.setLegajo("12345");
		var profesor1 = new Profesor("455564322", "Solo", "Han");
		profesor1.setCuil("206584001");
		
		
		Universidad.mostrarDatos(alumno1);
		Universidad.mostrarDatos(alumno2);
		Universidad.mostrarDatos(profesor1);
		
		var cursoJava = new Curso(123);
		
		cursoJava.agregarAlumno(alumno1);
		cursoJava.agregarAlumno(alumno2);
		cursoJava.setProfesor(profesor1);
		
		System.out.print("La cantidad de alumnos en el Curso es: ");
		System.out.println( cursoJava.getAlumnos().size() );
		
		AlumnoDAO alumnosEjemplo = new AlumnoDAO();
		
		alumnosEjemplo.connect();
		alumnosEjemplo.insert(alumno1);
		alumnosEjemplo.closeConnection();
		
		
	}

}
