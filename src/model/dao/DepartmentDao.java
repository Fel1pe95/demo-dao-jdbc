package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);
	void delete(Integer id);
	void update(Department obj);
	Department findById(Integer id);
	List<Department> findAll();
}
