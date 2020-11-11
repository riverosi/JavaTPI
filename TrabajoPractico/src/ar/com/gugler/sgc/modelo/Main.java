package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.gugler.dao.AlumnoDAO;
import ar.com.gugler.dao.ProfesorDAO;


/**
 * Main Class
 * @author Riveros Ignacio
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		var alumno1 = new Alumno("39539138", "Skywalker", "Anakin", "12346");
		var alumno2 = new Alumno("39123456", "Skywalker", "Luke", "12345");
		var profesor1 = new Profesor("455564322", "Solo", "Han", "206584001");
		
		Universidad.mostrarDatos(alumno1);
		Universidad.mostrarDatos(alumno2);
		Universidad.mostrarDatos(profesor1);
		
		var cursoJava = new Curso(123);
		
		cursoJava.agregarAlumno(alumno1);
		cursoJava.agregarAlumno(alumno2);
		cursoJava.setProfesor(profesor1);
		
		System.out.print("La cantidad de alumnos en el Curso es: ");
		System.out.println( cursoJava.getAlumnos().size() );
		
		AlumnoDAO alumnosDB = new AlumnoDAO();
		
		
		alumnosDB.connect();
		//alumnosDB.insert(alumno1);
		//alumno1.setApellido("changes");
		//alumno1.setNombres("cambio");
		//alumnosDB.update(alumno1);
		//System.out.println(alumno1.getId());
		//alumnosEjemplo.delete(alumno1);
		var lista = alumnosDB.getAll();
		for (Alumno alumno : lista) {
			System.out.println(alumno.mostrarInformacion());
		}
		alumnosDB.closeConnection();
		
		
		ProfesorDAO profesorDB = new ProfesorDAO();
		
		profesorDB.connect();
		profesorDB.insert(profesor1);
		profesorDB.closeConnection();
		
		
	}

}
