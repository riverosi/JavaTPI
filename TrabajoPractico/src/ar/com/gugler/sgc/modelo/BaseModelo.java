package ar.com.gugler.sgc.modelo;

/**
 * BaseModelo Class used for objects in database
 * 
 * @author Ignacio Riveros
 *
 */
public abstract class BaseModelo {
	protected Long id;

	/**
	 * Function to get id of BaseModelo object
	 * 
	 * @return Long id of object
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Function to set id in BaseModelo Object
	 * 
	 * @param id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
