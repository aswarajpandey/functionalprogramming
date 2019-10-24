package com.aswaraj.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {
	
	List<Employee> employeeList;

	public void addEmployee() {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 1998, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}
	
	private void printEmployeeDetails(Employee employee) {
		System.out.println("==============================================================");
		System.out.println("ID: "+ employee.getId());
		System.out.println("Name: "+ employee.getName());
		System.out.println("Gender: "+ employee.getGender());
		System.out.println("Department: "+ employee.getDepartment());
		System.out.println("Year of Joining: "+ employee.getYearOfJoining());
		System.out.println("Salary: "+ employee.getSalary());
		System.out.println();
	}

	/**
	 *  Count Employees by Gender.
	 */
	public void countByGender() {
		Map<String, Long> noOfMaleAndFemaleEmployees = 
				employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);
	}

	
	/**
	 * Print all the Departments.
	 */
	public void printDepartments() {
		employeeList.stream()
			.map(Employee::getDepartment)
			.distinct()
			.forEach(System.out::println);
	}
	
	/**
	 * Calculate average age Gender wise.
	 */
	public void printAvgAgeByGender() {
		Map<String, Double> avgGenderAge = 
				employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgGenderAge);
	}
	
	/**
	 * Fetches the details of highest paid Employee.
	 */
	public void getHighestPaidEmployee() {
		Optional<Employee> highestPaidEmployeeWrapper =
				employeeList.stream()
					.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		
		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println(highestPaidEmployee.toString());
	}
	
	/**
	 * Fetches details of Employee who has joined after 2015.
	 */
	public void filterEmployeeByJoiningDate() {
		employeeList.stream()
			.filter(e -> e.getYearOfJoining() > 2015)
			.map(Employee::getName)
			.forEach(System.out::println);
	}
	
	/**
	 * Counts no. of Employees, Department wise.
	 */
	public void countByDepartment() {
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
			.entrySet()
			.forEach(entry -> {
					System.out.println(entry.getKey() + ": " + entry.getValue());
				});
	}
	
	/**
	 * Fetches average salary Department wise.
	 */
	public void printAvgSalaryByDepartment() {
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
			.entrySet()
			.forEach(entry -> {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			});
	}
	
	/**
	 * Fetches youngest Employee of Product Development Department.
	 */
	public void filterYoungestEmployee() {
		Optional<Employee> youngestEmployeeWrapper = employeeList.stream()
			.filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
			.min(Comparator.comparingInt(Employee::getAge));
		
		Employee employee = youngestEmployeeWrapper.get();
		printEmployeeDetails(employee);
	}
	
	/**
	 * Fetches senior most Employee in the Organization.
	 */
	public void seniorMostEmployee() {
		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
			.sorted(Comparator.comparingInt(Employee::getYearOfJoining))
			.findFirst();
		printEmployeeDetails(seniorMostEmployeeWrapper.get());
	}
	
	
	/**
	 * Groups Gender and counts Employees.
	 */
	public void employeesByDepartments() {
		Map<String, Long> employeesByDepartmentsMap = employeeList.stream()
			.filter(e -> e.getDepartment().equals("Sales And Marketing"))
			.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println(employeesByDepartmentsMap);
	}
	
	/**
	 * Fetches average salary Gender wise.
	 */
	public void averageSalaryByGender() {
		Map<String, Double> averageSalaryByGenderMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		
		System.out.println(averageSalaryByGenderMap);		
	}
	
	public void getAllEmployeesByDepartment() {
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.entrySet()
			.forEach(entry -> 
						{
							System.out.println(entry.getKey());
							System.out.println("----------------------------------------------------------------");
							entry.getValue()
								.forEach(e -> printEmployeeDetails(e));
						}	
					);
	}
	
	public void updateEmployeeDepartment() {
		System.out.println("--------------------------------------Before Updation--------------------------------------");
		employeeList.stream().filter(e -> e.getSalary() > 30000)
			.forEach(e -> printEmployeeDetails(e));
		
		List<Employee> employeeTempList = employeeList.stream().filter(e -> e.getSalary() > 30000)
		.map(e -> {
				e.setDepartment("Manager");
				return e;
			})
		.collect(Collectors.toList());
		
		System.out.println("--------------------------------------After Updation--------------------------------------");
		employeeTempList.stream()
		.forEach(e -> printEmployeeDetails(e));
	}
	
	public void topPaidEmployeeByDepartment() {
		employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment,
					Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)))
			.entrySet().forEach(entry -> {
				System.out.println(entry.getKey());
				System.out.println("---------------------------------------------------------------");
				printEmployeeDetails(entry.getValue());
			});
	}

}
