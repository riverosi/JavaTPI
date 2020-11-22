package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.util.Date;
import ar.com.gugler.dao.AlumnoDAO;
import ar.com.gugler.dao.ProfesorDAO;

/**
 * Main Class
 * 
 * @author Riveros Ignacio
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		var alumno1 = new Alumno("39539138", "Skywalker", "Anakin", "12346");
//		var alumno2 = new Alumno("39123456", "Skywalker", "Luke", "12345");
//		var alumno3 = new Alumno("6665656", "C-3PO", "Robot", "123456");
		var alumnoAS = new Alumno("39539138", "Skywalker", "Anakin", new Date(), "Planeta exo",
				"141241", "anakinskywalker@starwars.com", "45453");
		var alumnoAL = new Alumno("39539139", "Skywalker", "Luke", new Date(), "Planeta exo",
				"141243", "lukeskywalker@starwars.com", "45454");
		
		var profesorHS = new Profesor("1324914", "345345", "Solo", "Han", new Date(), "Estrella", "12341234",
				"hansolo@starwars.com", new Date());
//		var profesor1 = new Profesor("4555643", "Solo", "Han", "206584001");
//		var profesor2 = new Profesor("455564322", "Kenobi", "Obi-Wan", "874001");
//		var profesor3 = new Profesor("44444", "Darth", "Vader", "12354");

		Universidad.mostrarDatos(alumnoAS);
		Universidad.mostrarDatos(alumnoAS);
		Universidad.mostrarDatos(profesorHS);

		var cursoJava = new Curso(123);

		cursoJava.agregarAlumno(alumnoAS);
		cursoJava.agregarAlumno(alumnoAL);
		cursoJava.setProfesor(profesorHS);

		System.out.print("La cantidad de alumnos en el Curso es: ");
		System.out.println(cursoJava.getAlumnos().size());

		/*
		 * DATA BASE PROFESOR
		 */
		ProfesorDAO profesorDB = new ProfesorDAO();

//		profesorDB.insert(profesorHS);

		var listaProfesores = profesorDB.getAll();
		for (Profesor profesor : listaProfesores) {
			Universidad.mostrarDatos(profesor);
		}
		listaProfesores.get(0).setDomicilio("La luna");
		profesorDB.update(listaProfesores.get(0));
		
		/*
		 * DATA BASE ALUMNOS
		 */
		AlumnoDAO alumnosDB = new AlumnoDAO();
//		alumnosDB.insert(alumnoAL);
//		alumnosDB.insert(alumnoAS);
//		
		var listaAlumnos = alumnosDB.getAll();
		for (Alumno alumno : listaAlumnos) {
			Universidad.mostrarDatos(alumno);
		}
		listaAlumnos.get(0).setApellido("Cambio el apellido");
		alumnosDB.update(listaAlumnos.get(0));
		alumnosDB.delete(1L);
	}

}
