/**
 * 
 */
package ar.com.gugler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;

/**
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

	public boolean insert(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(this.getInsertSql());
		this.setValuesInsert(preparedStatement, object);
		return preparedStatement.execute();
	}

	public boolean update(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(this.getUpdateSql());
		this.setValuesUpdate(preparedStatement, object);
		return preparedStatement.execute();
	}

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

	public int delete(T object) throws SQLException {
		java.sql.Connection connection = Connection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from tp." + this.getTable() + " where id = ? ");
		preparedStatement.setLong(1, object.getId());
		return preparedStatement.executeUpdate();
	}

}
