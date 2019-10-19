package com.aswaraj.streams;

import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		employeeService.addEmployee();
		int option = 7;
		
		switch (option) {
		case 1:
			employeeService.countByGender();
			break;
		case 2:
			employeeService.printDepartments();
			break;
		case 3:
			employeeService.printAvgAgeByGender();
		case 4:
			employeeService.getHighestPaidEmployee();
		case 5:
			employeeService.filterEmployeeByJoiningDate();
		case 6:
			employeeService.countByDepartment();
		case 7:
			employeeService.printAvgSalaryByDepartment();
		default:
			break;
		}
	}
}
