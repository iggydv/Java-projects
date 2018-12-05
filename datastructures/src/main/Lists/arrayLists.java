package main.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class arrayLists {
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Clara", "Chennells", 1));
		employeeList.add(new Employee("Ignatius", "de Villiers", 15));
		employeeList.add(new Employee("Ian", "de Villiers", 323));
		
		List<Employee> employeeList2 = new Vector<Employee>();
		
		employeeList.forEach(employee -> System.out.println(employee.toString()));
	}

}
