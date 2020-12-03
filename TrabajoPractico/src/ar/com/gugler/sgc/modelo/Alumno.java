package ar.com.gugler.sgc.modelo;

import java.util.Date;

/**
 * Alumno Class
 * 
 * @author Ignacio Riveros
 *
 */
public class Alumno extends Persona {

	private String legajo;

	/**
	 * Short Contructor of Alumno
	 * 
	 * @param numeroDocumento number of document
	 * @param apellido        second name
	 * @param nombres         first name
	 */
	public Alumno(String numeroDocumento, String apellido, String nombres) {
		super(numeroDocumento, apellido, nombres);
	}

	public Alumno(String numeroDocumento, String apellido, String nombres, String legajo) {
		super(numeroDocumento, apellido, nombres);
		this.legajo = legajo;
	}

	public Alumno(String numeroDocumento2, String apellido2, String nombres2, Date fechaNacimiento2, String domicilio2,
			String telefono2, String correoElectronico2, String legajo2) {
		super(numeroDocumento2, apellido2, nombres2, fechaNacimiento2, domicilio2, telefono2, correoElectronico2);
		this.legajo = legajo2;

	}

	/**
	 * Function to get legajo of alumno
	 * 
	 * @return legajo String
	 */
	public String getLegajo() {
		return legajo;
	}

	/**
	 * Function to set legajo in alumno
	 * 
	 * @param legajo
	 */
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	@Override
	public String mostrarInformacion() {
		return "Alumno [Nombre y apellido= " + this.getNombres() + " " + this.getApellido() + ", DNI: "
				+ this.getNumeroDocumento() + "]";
	}

	@Override
	public String toString() {
		return "Alumno [legajo= " + legajo + ", id= " + id + ", NumeroDocumento= " + getNumeroDocumento()
				+ ", Nombres y Apellido= " + getApellido() + " " + getNombres() + "]";
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
