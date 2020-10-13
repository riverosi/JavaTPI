package ar.com.gugler.sgc.modelo;

public class Curso extends Asignatura implements Administrable {
	/**
	 * Attibutes
	 */
	private Integer curso;
	/**
	 * Constructors
	 */
	public Curso() {
		super();
	}
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
	 * Function to add alumno in Curso
	 * @param alumno
	 * @return void
	 */
	public void agregarAlumno(Alumno alumno) {
		var ret = this.getAlumnos();
		ret.add(alumno);
		this.setAlumnos(ret);
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
		if (this.getAlumnos().size() < 24) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
