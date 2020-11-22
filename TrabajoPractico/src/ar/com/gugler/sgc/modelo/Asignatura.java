package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura extends BaseModelo {
	/**
	 * Attributes
	 */
	private Integer codigo;
	private String nombre;
	private List<Alumno> alumnos;
	private Profesor profesor;

	/**
	 * Constructors
	 */
	public Asignatura() {
		super();
		alumnos = new ArrayList<Alumno>();
	}

	public Asignatura(Integer codigo, String nombre, Long idProfesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesor.setId(idProfesor);
		alumnos = new ArrayList<Alumno>();
	}

	/**
	 * Getters and Setters
	 */
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	/**
	 * Methods of class
	 */
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", profesor=" + profesor + "]";
	}

}
