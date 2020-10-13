package ar.com.gugler.sgc.modelo;

public class Alumno extends Persona {
	/**
	 * Attributes
	 */
	
	private String legajo;
	/**
	 * Constructors
	 */
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	public Alumno(String numeroDocumento, String apellido, String nombres) {
		super(numeroDocumento, apellido, nombres);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Getters and Setters
	 */
	
	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	/**
	 * Methods of class
	 */
	
	@Override
	public String mostrarInformacion() {
		return "Alumno [Nombre y apellido= " + this.getNombres() +" "+ this.getApellido() +", DNI: "+ this.getNumeroDocumento() +"]";
	}

	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		return true;
	}
	

}
