package main.Lists;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size = 0;

    public void addToFront(Employee employee) {
        size++;
        // new node
        EmployeeNode node = new EmployeeNode(employee);
        // add at front
        node.setNext(head);
        // make new head
        head = node;
    }

    public void addToTail(Employee employee) {
        size++;
        // new node
        EmployeeNode node = new EmployeeNode(employee);
        // add at front
        node.setNext(head);
        // make new head
        head = node;
    }


    public void removeFromFront() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        System.out.println("Removing");
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }
}
