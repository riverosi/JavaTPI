package ar.com.gugler.sgc.modelo;

/**
 * Curso Class
 * 
 * @author Ignacio Riveros
 *
 */
public class Curso extends Asignatura implements Administrable {
	private Integer cupo;
	final private Integer MAX_ALUMNOS = 24;

	public Curso(Integer codigo, String nombre, Profesor profesor, Integer cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCurso(Integer curso) {
		this.cupo = curso;
	}

	/**
	 * Function to add alumno in list of Curso
	 * 
	 * @param alumno
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
	 * 
	 */
	public void eliminarAlumno(Alumno alumno) {
		this.getAlumnos().remove(alumno);
	}

	@Override
	public boolean admiteInscripciones() {
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
