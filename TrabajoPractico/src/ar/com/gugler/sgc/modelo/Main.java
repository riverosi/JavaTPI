package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.util.Date;

import ar.com.gugler.sgc.dao.AlumnoDAO;
import ar.com.gugler.sgc.dao.CursoDAO;
import ar.com.gugler.sgc.dao.MateriasDAO;
import ar.com.gugler.sgc.dao.ProfesorDAO;

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

		/*
		 * DATA BASE PROFESOR
		 */
		ProfesorDAO profesorDB = new ProfesorDAO();

//		profesorDB.insert(profesorHS);
//		profesorDB.insert(profesorKO);
		System.out.println();
		System.out.println("List of Profesores in Data Base:");
		var listaProfesores = profesorDB.getAll();
		for (Profesor profesor : listaProfesores) {
			System.out.println(profesor);
		}

//		listaProfesores.get(0).setDomicilio("La luna");
//		profesorDB.update(listaProfesores.get(0));

		/*
		 * DATA BASE ALUMNOS
		 */
		AlumnoDAO alumnosDB = new AlumnoDAO();
//		alumnosDB.insert(alumnoAL);
//		alumnosDB.insert(alumnoAS);
		System.out.println();
		System.out.println("List of alumnos in Data Base:");
		var listaAlumnos = alumnosDB.getAll();
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}
		listaAlumnos.get(0).setApellido("Obi-Wan");
		alumnosDB.update(listaAlumnos.get(0));
//		alumnosDB.delete(2L);
		/*
		 * DATABASE DE MATERIAS
		 */
		var fuerza = new Materia(135, "Estrellas y galaxias", listaProfesores.get(0), 2020);
		fuerza.setAlumnos(listaAlumnos);
		fuerza.setProfesor(listaProfesores.get(0));
		var materiasDB = new MateriasDAO();
//		materiasDB.insert(fuerza);
		System.out.println();
		System.out.println("List of materias in Data Base:");
		var listaMaterias = materiasDB.getAll();
		for (Materia materia : listaMaterias) {
			System.out.println(materia);
			materia = materiasDB.get(materia.getId());
			for (var alumno : materia.getAlumnos()) {
				System.out.println(alumno);
			}
		}
//		materiasDB.delete(listaMaterias.get(0));
		/*
		 * DATA BASE CURSO
		 */
		var cursoJava = new Curso(123, "Curso de Python", listaProfesores.get(0), 1234);
		cursoJava.setAlumnos(listaAlumnos);

		var cursoDB = new CursoDAO();
//		cursoDB.insert(cursoJava);
		var listaCursos = cursoDB.getAll();
		System.out.println();
		System.out.println("List of cursos in Data Base:");
		for (Curso curso : listaCursos) {

			System.out.println(curso);
			curso = cursoDB.get(curso.getId());

			if (curso.getAlumnos().size() > 0) {
				System.out.println("Alumnos in this Curso:");
				for (var alumno : curso.getAlumnos()) {
					System.out.println(alumno);
				}
			}

			else {
				System.out.println("Empty Curso");
			}

		}

	}

}
