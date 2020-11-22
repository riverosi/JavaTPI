package ar.com.gugler.sgc.modelo;

import java.util.Date;

public abstract class Persona extends BaseModelo{
	
	/**
	 * Attributes
	 */
	private String numeroDocumento;
	private String apellido;
	private String nombres;
	private Date fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String correoElectronico;
	/**
	 * Constructors
	 */
	
	public Persona(String numeroDocumento, String apellido, String nombres) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
	}
	public Persona(String numeroDocumento2, String apellido2, String nombres2, Date fechaNacimiento2, String domicilio2,
			String telefono2, String correoElectronico2) {
		// TODO Auto-generated constructor stub
		super();
		this.numeroDocumento = numeroDocumento2;
		this.apellido = apellido2;
		this.nombres = nombres2;
		this.fechaNacimiento = fechaNacimiento2;
		this.domicilio = domicilio2;
		this.telefono = telefono2;
		this.correoElectronico = correoElectronico2;
	}
	/**
	 * Getters and Setters of class
	 */
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
	/**
	 * Methods of class
	 */
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
