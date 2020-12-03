package ar.com.gugler.sgc.modelo;

import java.util.Date;

/**
 * Persona Class
 * 
 * @author Ignacio Riveros
 *
 */
public abstract class Persona extends BaseModelo {

	private String numeroDocumento;
	private String apellido;
	private String nombres;
	private Date fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String correoElectronico;

	/**
	 * Short Constructor of Persona
	 * 
	 * @param numeroDocumento number of document
	 * @param apellido        second name
	 * @param nombres         first name
	 */
	public Persona(String numeroDocumento, String apellido, String nombres) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
	}

	/**
	 * Long Constructor of Persona
	 * 
	 * @param numeroDocumento2   number of document
	 * @param apellido2          second name
	 * @param nombres2           first name
	 * @param fechaNacimiento2   date of birth
	 * @param domicilio2         address
	 * @param telefono2          telephone
	 * @param correoElectronico2 email
	 */
	public Persona(String numeroDocumento2, String apellido2, String nombres2, Date fechaNacimiento2, String domicilio2,
			String telefono2, String correoElectronico2) {
		super();
		this.numeroDocumento = numeroDocumento2;
		this.apellido = apellido2;
		this.nombres = nombres2;
		this.fechaNacimiento = fechaNacimiento2;
		this.domicilio = domicilio2;
		this.telefono = telefono2;
		this.correoElectronico = correoElectronico2;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public abstract String mostrarInformacion();

	@Override
	public String toString() {
		return "Persona [numeroDocumento=" + numeroDocumento + ", apellido=" + apellido + ", nombres=" + nombres + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		return true;
	}

}
