package aplication;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		System.out.println(" === TESTE 1: INSERT Department === ");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		departmentDao.insert(new Department(6, "musica"));
		System.out.println("Insert complete!");
		
		
		/*System.out.println(" === TESTE 2: DELETE Department === ");
		departmentDao.delete(6);
		System.out.println("Delete complete!");*/
		
		

	}

}
