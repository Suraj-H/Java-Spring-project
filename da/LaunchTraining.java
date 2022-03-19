package com.mikadosolutions.training.spring.da;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LaunchTraining {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\SurajH\\OneDrive\\Documents\\Java\\Spring\\src\\com\\mikadosolutions\\training\\spring\\da\\TrainingConfig.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeedao");

//		System.out.println(dao.getTotalEmployees());
//		System.out.println(dao.countOfEmployeesByName("Sunil"));
//		System.out.println(dao.getNameForId(1));
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getAllEmployees());

//		dao.addEmployee(new Employee(11, "john", 10_000));
//		dao.editEmployee(new Employee(11, null, 30_000));
//		dao.deleteEmployee(new Employee(11, null, 30_000));
//		dao.createTable();

		System.out.println(dao.countOfEmployeesByFirstName("Sunil"));
		dao.addEmployee(new Employee(12, "sanjay", 40_000));
	}
}