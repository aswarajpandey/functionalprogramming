package com.aswaraj.streams;

import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		employeeService.addEmployee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter option: ");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			employeeService.countByGender();
			break;
		case 2:
			employeeService.printDepartments();
			break;
		case 3:
			employeeService.printAvgAgeByGender();
			break;
		case 4:
			employeeService.getHighestPaidEmployee();
			break;
		case 5:
			employeeService.filterEmployeeByJoiningDate();
			break;
		case 6:
			employeeService.countByDepartment();
			break;
		case 7:
			employeeService.printAvgSalaryByDepartment();
			break;
		case 8:
			employeeService.filterYoungestEmployee();
			break;
		case 9:
			employeeService.seniorMostEmployee();
			break;
		case 10:
			employeeService.employeesByDepartments();
			break;
		case 11:
			employeeService.averageSalaryByGender();
			break;
		case 12:
			employeeService.getAllEmployeesByDepartment();
			break;
		case 13:
			employeeService.updateEmployeeDepartment();
			break;
		case 14:
			employeeService.topPaidEmployeeByDepartment();
			break;
		default:
			break;
		}
	}
}
