package ar.com.gugler.sgc.modelo;

public class Materia extends Asignatura {
	/**
	 * Attributes
	 */
	private Integer anio;
	/**
	 * Constructors
	 */
	public Materia(Integer anio) {
		super();
		this.anio = anio;
	}
	public Materia(Integer codigo, String nombre, Profesor profesor, Integer anio) {
		super(codigo, nombre, profesor);
		this.anio = anio;
	}

	/**
	 * Getters and Setters
	 */
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	@Override
	public String toString() {
		return "Materia [anio= " + anio + ", id= " + id + ", Nombre= " + this.getNombre() + "]";
	}


}
