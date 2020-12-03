package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Asignatura Class
 * 
 * @author river
 *
 */
public class Asignatura extends BaseModelo {

	private Integer codigo;
	private String nombre;
	private List<Alumno> alumnos;
	private Profesor profesor;

	public Asignatura() {
		super();
		alumnos = new ArrayList<Alumno>();
	}

	/**
	 * Short Constructor of Asignatura
	 * 
	 * @param codigo   code
	 * @param nombre   number
	 * @param profesor Profesor
	 */
	public Asignatura(Integer codigo, String nombre, Profesor profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesor = profesor;
		alumnos = new ArrayList<Alumno>();
	}

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

	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", profesor=" + profesor + "]";
	}

}
