package main.Lists;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedLists {

	public static void main(String[] args) {
		Employee clara = new Employee("Clara", "Chennells", 1);
		Employee ig = new Employee("Ig", "de Villiers", 2);
		Employee cois = new Employee("Cois", "de Villiers", 3);
		Employee ian = new Employee("Ian", "de Villiers", 4);
		Employee boets = new Employee("Boets", "de Villiers", 5);

		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(clara);
		list.addToFront(ig);
		list.addToFront(boets);
		list.addToFront(cois);

		list.printList();

		list.removeFromFront();
		list.printList();

		EmployeeDoublyLinkedList list2 = new EmployeeDoublyLinkedList();
		list2.addToFront(clara);
		list2.addToFront(ig);
		list2.printList();
		list2.addToTail(ian);
		list2.printList();

		LinkedList<Employee> list3 = new LinkedList<>();
		list3.addFirst(clara);
		list3.addFirst(ig);

		Iterator iter = list3.iterator();
		System.out.print("HEAD -> ");
		while (iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <-> ");
		}
		System.out.println("null");
	}

}
