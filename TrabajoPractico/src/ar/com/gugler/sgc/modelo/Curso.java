package ar.com.gugler.sgc.modelo;

public class Curso extends Asignatura implements Administrable {
	/**
	 * Attibutes
	 */
	private Integer cupo;
	final private Integer MAX_ALUMNOS = 24;

	/**
	 * Constructors
	 */
	public Curso(Integer codigo, String nombre, Profesor profesor, Integer cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getCupo() {
		return cupo;
	}

	public void setCurso(Integer curso) {
		this.cupo = curso;
	}

	/**
	 * Methods of class
	 */
	/**
	 * Function to add alumno in list of Curso
	 * 
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
	 * 
	 * @param alumno
	 * @retun void
	 */
	public void eliminarAlumno(Alumno alumno) {
		this.getAlumnos().remove(alumno);
	}

	@Override
	public boolean admiteInscripciones() {
		// TODO Auto-generated method stub
		if (this.getAlumnos().size() < MAX_ALUMNOS) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "Curso [Cupo=" + cupo + ", Codigo=" + getCodigo() + ", Nombre=" + getNombre() + "]";
	}

}
