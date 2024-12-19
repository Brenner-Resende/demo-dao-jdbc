package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			
			System.out.println("--- TEST 1: department findById ---");
			Department dep = departmentDao.findById(2);
			System.out.println(dep);
			
			System.out.println("\n--- TEST 2: department findAll ---");
			List<Department> list = departmentDao.findAll();
			for(Department x : list) {
				System.out.println(x);
			}
			
			System.out.println("\n--- TEST 3: department insert ---");
			Department newDepartment = new Department(null, "Management");
			
			departmentDao.insert(newDepartment);
			System.out.println("Inserted! New department id = " + newDepartment.getId());
			 
			
			System.out.println("\n--- TEST 4: department update ---");
			Department updatedDep = departmentDao.findById(6);
			updatedDep.setName("PR");
			departmentDao.update(updatedDep);
			System.out.println("Update completed");
			
			System.out.println("\n--- TEST 5: department delete ---");
			System.out.println("Enter id for department deletion: ");
			int id = sc.nextInt();
			departmentDao.deleteById(id);
			System.out.println("Deleted successfully");
					
			sc.close();
	}

}
