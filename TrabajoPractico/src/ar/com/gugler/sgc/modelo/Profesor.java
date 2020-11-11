package ar.com.gugler.sgc.modelo;

import java.util.Date;

public class Profesor extends Persona {
	
	/**
	 * Attributes
	 */
	private String cuil;
	private Date fechaIngreso;
	/**
	 * Constructors
	 */
	
	public Profesor(String numeroDocumento, String apellido, String nombres) {
		super(numeroDocumento, apellido, nombres);
		// TODO Auto-generated constructor stub
	}
	
	public Profesor(String numeroDocumento, String apellido, String nombres, String cuil) {
		super(numeroDocumento, apellido, nombres);
		this.cuil = cuil;
	}

	/**
	 * Getters and Setters
	 */
	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	/**
	 * Methods of class
	 */
	
	@Override
	public String mostrarInformacion() {
		// TODO Auto-generated method stub
		return "Profesor [Nombre y apellido= " + this.getNombres().toUpperCase() + " " + this.getApellido().toUpperCase() + 
				", Cuil: "+ this.getCuil() + "]"; 
	}

	@Override
	public String toString() {
		return "Profesor [cuil=" + cuil + ", fechaIngreso=" + fechaIngreso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cuil == null) ? 0 : cuil.hashCode());
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
		Profesor other = (Profesor) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		return true;
	}
	
	

}
