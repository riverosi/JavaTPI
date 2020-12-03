package ar.com.gugler.sgc.modelo;

/**
 * Materia Class
 * 
 * @author Igancio Riveros
 *
 */
public class Materia extends Asignatura {
	private Integer anio;

	/**
	 * Short Constructor of Materia
	 * 
	 * @param anio year
	 */
	public Materia(Integer anio) {
		super();
		this.anio = anio;
	}

	/**
	 * Long constructor of Materia
	 * 
	 * @param codigo   code
	 * @param nombre   name
	 * @param profesor Profesor
	 * @param anio     year
	 */
	public Materia(Integer codigo, String nombre, Profesor profesor, Integer anio) {
		super(codigo, nombre, profesor);
		this.anio = anio;
	}

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
