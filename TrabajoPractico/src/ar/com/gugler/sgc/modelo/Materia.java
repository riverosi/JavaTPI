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
	/**
	 * Getters and Setters
	 */
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	

}
