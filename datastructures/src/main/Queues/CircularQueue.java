package main.Queues;

import java.util.NoSuchElementException;

public class CircularQueue {

    private Employee[] queue;
    private int front = 0;
    private int back = 0;

    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee e) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2*queue.length];
            // to handle wrapping of the array
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray,queue.length - front, back);
            queue = newArray;
            front = 0;
            back = numItems;
        }
        queue[back] = e;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public void remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return (front <= back) ? (back - front) : (back - front + queue.length);
    }
}
