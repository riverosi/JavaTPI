package ar.com.gugler.sgc.modelo;

public class Curso extends Asignatura implements Administrable {
	/**
	 * Attibutes
	 */
	private Integer curso;
	private Integer cantidadAlumnos = 24;
	/**
	 * Constructors
	 */
	public Curso(Integer curso) {
		super();
		this.curso = curso;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	/**
	 * Methods of class
	 */
	/**
	 * Function to add alumno in list of Curso
	 * @param alumno to add
	 * @return when if succesfull return true, else return false 
	 */
	public boolean agregarAlumno(Alumno alumno) {
		if (admiteInscripciones()) {
			this.getAlumnos().add(alumno);
			return true;
		}
		return false;
	}
	/**
	 * Function to remove alumno in List of Curso
	 * @param alumno
	 * @retun void
	 */
	public void eliminarAlumno(Alumno alumno) {
		this.getAlumnos().remove(alumno);
	}
	
	@Override
	public boolean admiteInscripciones() {
		// TODO Auto-generated method stub
		if (this.getAlumnos().size() < cantidadAlumnos) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
