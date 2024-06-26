package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDaoJDBC();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.print(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: department insert ===");
		Department newDepartment = new Department(3,"D3");
		departmentDao.insert(newDepartment);
		System.out.println("Insertd! New id = "+newDepartment.getId());
		
		System.out.println("\n=== TEST 5: department update ===");
		Department dp = departmentDao.findById(1);
		
		dp.setName("D5");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
