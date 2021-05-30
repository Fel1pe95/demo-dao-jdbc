package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection con;

	public DepartmentDaoJDBC(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("INSERT INTO Department (Id, name) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());

			int rows = st.executeUpdate();

			if (rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);

			}
			System.out.println("Insert complete. rows affected: " + rows);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		try {

			st = con.prepareStatement("DELETE FROM Department WHERE id = ?");
			st.setInt(1, id);

			int rows = st.executeUpdate();
			System.out.println("Delete complete! linhas afetadas: " + rows);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("UPDATE Department SET Name = ? WHERE Id = ?");

			st.setInt(2, obj.getId());
			st.setString(1, obj.getName());

			st.executeUpdate();
			int rows = st.executeUpdate();
			System.out.println("Update complete! rows affected: " + rows);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM department WHERE Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = con.prepareStatement("SELECT * FROM department ");
			
			rs = st.executeQuery();
			List<Department>list = new ArrayList<>();
			while(rs.next()) {
				Department dep = instantiateDepartment(rs);
				list.add(dep);
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}
}
