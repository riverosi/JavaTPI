package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.util.Date;

import ar.com.gugler.dao.AlumnoDAO;
import ar.com.gugler.dao.MateriasDAO;
import ar.com.gugler.dao.ProfesorDAO;

/**
 * Main Class
 * 
 * @author Riveros Ignacio
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws SQLException {

		var alumnoAS = new Alumno("39539138", "Skywalker", "Anakin", new Date(), "Planeta exo", "141241",
				"anakinskywalker@starwars.com", "45453");
		var alumnoAL = new Alumno("39539139", "Skywalker", "Luke", new Date(), "Planeta exo", "141243",
				"lukeskywalker@starwars.com", "45454");
		var alumnoCT = new Alumno("6665656", "C-3PO", "Robot", new Date(), "Destructor Imperial", "654654",
				"ctripioelrobot@starwars.com", "45642");

		var profesorHS = new Profesor("1324914", "345345", "Solo", "Han", new Date(), "Halcón Milenario", "12341234",
				"hansolo@starwars.com", new Date());
		var profesorKO = new Profesor("455564322", "321654", "Kenobi", "Obi-Wan", new Date(), "Kanimo", "654654",
				"obi-wan-kenobi@starwars.com", new Date());

//		var profesor3 = new Profesor("44444", "Darth", "Vader", "12354");

//		Universidad.mostrarDatos(alumnoAS);
//		Universidad.mostrarDatos(alumnoAS);
//		Universidad.mostrarDatos(profesorHS);

		var cursoJava = new Curso(123);

		cursoJava.agregarAlumno(alumnoAS);
		cursoJava.agregarAlumno(alumnoAL);
		cursoJava.agregarAlumno(alumnoCT);
		cursoJava.setProfesor(profesorHS);

		System.out.print("La cantidad de alumnos en el Curso es: ");
		System.out.println(cursoJava.getAlumnos().size());

		/*
		 * DATA BASE PROFESOR
		 */
		ProfesorDAO profesorDB = new ProfesorDAO();

//		profesorDB.insert(profesorHS);
//		profesorDB.insert(profesorKO);

		var listaProfesores = profesorDB.getAll();
		for (Profesor profesor : listaProfesores) {
			Universidad.mostrarDatos(profesor);
		}

//		listaProfesores.get(0).setDomicilio("La luna");
//		profesorDB.update(listaProfesores.get(0));

		/*
		 * DATA BASE ALUMNOS
		 */
		AlumnoDAO alumnosDB = new AlumnoDAO();
//		alumnosDB.insert(alumnoAL);
//		alumnosDB.insert(alumnoAS);
		
		var listaAlumnos = alumnosDB.getAll();
		for (Alumno alumno : listaAlumnos) {
			Universidad.mostrarDatos(alumno);
		}
		listaAlumnos.get(0).setApellido("Obi-Wan");
		alumnosDB.update(listaAlumnos.get(0));
		alumnosDB.delete(2L);
		/*
		 * DATABASE DE MATERIAS
		 */
		var biologia = new Materia(135, "Introducción a la Fuerza", listaProfesores.get(0).getId(), 2020);
		biologia.setAlumnos(listaAlumnos);
		biologia.setProfesor(listaProfesores.get(0));
		var materiasDAO = new MateriasDAO();
		materiasDAO.insert(biologia);


	}

}
