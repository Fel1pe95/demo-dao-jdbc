package aplication;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		System.out.println(" === TESTE 1: INSERT Department === ");

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		/*
		 * departmentDao.insert(new Department(6, "musica"));
		 * System.out.println("Insert complete!");
		 * 
		 * 
		 * System.out.println(" === TESTE 2: DELETE Department === ");
		 * departmentDao.delete(6); System.out.println("Delete complete!");
		 */

		System.out.println(" === TESTE 4: Department findById === ");
		Department dep = departmentDao.findById(2);
		
		System.out.println(dep);

		/*
		 * System.out.println(" === TESTE 4: Update Department === ");
		 * departmentDao.update(null);
		 */

		System.out.println(" === TESTE 5: Department Update === ");
	    dep = departmentDao.findById(3);
		dep.setName("Music");
		departmentDao.update(dep);
		System.out.println("Update complete!");

		
		System.out.println(" === TESTE 6: Department findAll === ");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
	}

}
