package ar.com.gugler.sgc.modelo;

import java.util.Date;

/**
 * Profesor Class
 * 
 * @author Ignacio Riveros
 *
 */
public class Profesor extends Persona {

	private String cuil;
	private Date fechaIngreso;

	/**
	 * Short Constructor of Profesor
	 * 
	 * @param numeroDocumento
	 * @param apellido
	 * @param nombres
	 */
	public Profesor(String numeroDocumento, String apellido, String nombres) {
		super(numeroDocumento, apellido, nombres);
	}

	/**
	 * Long Constructor of Profesor
	 * 
	 * @param cuil
	 * @param numeroDocumento
	 * @param apellido
	 * @param nombres
	 * @param fechaNacimiento
	 * @param domicilio
	 * @param telefono
	 * @param correoElectronico
	 * @param fechaIngreso
	 */
	public Profesor(String cuil, String numeroDocumento, String apellido, String nombres, Date fechaNacimiento,
			String domicilio, String telefono, String correoElectronico, Date fechaIngreso) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}

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

	@Override
	public String mostrarInformacion() {
		return "Profesor [Nombre y apellido= " + this.getNombres().toUpperCase() + " "
				+ this.getApellido().toUpperCase() + ", Cuil: " + this.getCuil() + "]";
	}

	@Override
	public String toString() {
		return "Profesor [cuil= " + cuil + ", fechaIngreso= " + fechaIngreso + ", id= " + id
				+ ", getNumeroDocumento()= " + getNumeroDocumento() + ", getApellido()= " + getApellido()
				+ ", getNombres()= " + getNombres() + "]";
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
