package ar.com.gugler.sgc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;

/**
 * GenericDAO Class used for Data Access Object Software Pattern
 * 
 * @author Ignacio Riveros
 *
 */
public abstract class GenericDAO<T extends BaseModelo> {

	protected abstract String getTable();

	protected abstract String getInsertSql();

	protected abstract void setValuesInsert(PreparedStatement preparedStatement, T object) throws SQLException;

	protected abstract void setValuesUpdate(PreparedStatement preparedStatement, T object) throws SQLException;

	protected abstract String getUpdateSql();

	protected abstract T populate(ResultSet rs) throws SQLException;

	/**
	 * insert a object in table of data base. This function also adds the objects in
	 * foreign key tables.
	 * 
	 * @param object object to insert
	 * @return value of query result
	 * @throws SQLException
	 */
	public boolean insert(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(this.getInsertSql());
		this.setValuesInsert(preparedStatement, object);
		return preparedStatement.execute();
	}

	/**
	 * update an object in data base. This function don't modify the tables whit
	 * foreign keys.
	 * 
	 * @param object object to update values in data base
	 * @return value of query result
	 * @throws SQLException
	 */
	public boolean update(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(this.getUpdateSql());
		this.setValuesUpdate(preparedStatement, object);
		return preparedStatement.execute();
	}

	/**
	 * return an object from its associated identifier in the table of database.
	 * 
	 * @param id identifier of object in data base
	 * @return the object associated with its identifier
	 * @throws SQLException
	 */
	public T get(Long id) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from " + this.getTable() + " where id = ? ");
		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return this.populate(rs);
		}
		return null;
	}

	/**
	 * return a list of object whit all objects are presents in table of data base.
	 * 
	 * @return List of objects
	 * @throws SQLException
	 */
	public List<T> getAll() throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from " + this.getTable());
		ResultSet rs = preparedStatement.executeQuery();
		List<T> result = new ArrayList<T>();
		while (rs.next()) {
			result.add(this.populate(rs));
		}
		return result;
	}

	/**
	 * delete a object in table if data base. This function remove occurrences in
	 * foreign tables
	 * 
	 * @param object
	 * @return number or rows removed
	 * @throws SQLException
	 */
	public int delete(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from tp." + this.getTable() + " where id = ? ");
		preparedStatement.setLong(1, object.getId());
		return preparedStatement.executeUpdate();
	}

}
