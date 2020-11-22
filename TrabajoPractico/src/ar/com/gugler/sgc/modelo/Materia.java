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
	public Materia(Integer codigo, String nombre, Long id_profesor, Integer anio) {
		super(codigo, nombre, id_profesor);
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
