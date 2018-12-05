package main.Lists;

public class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size = 0;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        if (size == 0) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        size++;
    }

    public void addToTail(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }


    public void removeFromFront() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        System.out.println("Removing");
        EmployeeNode removedNode = head;
        if (removedNode.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
    }

    public void removeFromEnd() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        System.out.println("Removing");
        EmployeeNode removedNode = tail;
        if (removedNode.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }
}
