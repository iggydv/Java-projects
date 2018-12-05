package Task3;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

// for this test I will be implementing a LinkedStack
// i.e. a stack created by using a JDK provided LinkedList

public class Solution {

    private volatile LinkedList<Integer> stack;
    private ThreadLocal<LinkedList<Integer>> transactionStack;

    private ThreadLocal<Boolean> threadFlag = ThreadLocal.withInitial(() -> false);
    private ThreadLocal<Boolean> commitFlag = ThreadLocal.withInitial(() -> false);


    public Solution() {
        stack = new LinkedList<>();
        transactionStack = ThreadLocal.withInitial(LinkedList::new);
    }

    // Push onto top of stack
    public void push(int value) {
        if ((transactionStack.get().isEmpty() && !threadFlag.get()) || (transactionStack.get().isEmpty() && commitFlag.get())) {
            System.out.println("pushing to stack -> " + value);
            stack.push(value);
            return;
        }
        System.out.println("pushing to t_stack -> " + value);
        transactionStack.get().push(value);
    }

    // Peek top of stack
    public int top() {
        if (transactionStack.get().isEmpty() && !threadFlag.get()) {
            if (stack.isEmpty()) {
                throw new EmptyStackException();
            }
            System.out.println("Stack top -> " + stack.peek());
            return stack.peek();
        }
        System.out.println("t_stack top -> " + transactionStack.get().peek());
        return transactionStack.get().peek();
    }

    // Pop top value from stack
    public int pop() {
        if (transactionStack.get().isEmpty() && !threadFlag.get()) {
            if (stack.isEmpty()) {
                throw new EmptyStackException();
            }
            System.out.println("popping from stack -> " + stack.peek());
            return stack.pop();
        }
        if (!transactionStack.get().isEmpty()) {
            System.out.println("popping from t_stack -> " + transactionStack.get().peek());
            return transactionStack.get().pop();
        }
        throw new EmptyStackException();
    }

    public void begin() {
        threadFlag.set(true);
    }

    public boolean rollback() {
        System.out.println("Starting rollback");
        if (transactionStack.get().isEmpty() && !threadFlag.get()) {
            System.out.println("Empty, cannot perform rollback");
            return false;
        }
        while (!transactionStack.get().isEmpty() && threadFlag.get()) {
            this.pop();
        }
        commitFlag.set(false);
        threadFlag.set(false);
        return true;
    }

    public synchronized boolean commit() {
        commitFlag.set(true);
        // if t_stack is not in use and not a thread
        if (transactionStack.get().isEmpty() || !threadFlag.get()) {
            return false;
        }
        LinkedList<Integer> stack2 = Reverse(transactionStack.get());
        while (!stack2.isEmpty()) {
            int value = stack2.pop();
            this.push(value);
        }
        commitFlag.set(false);
        threadFlag.set(false);
        return true;
    }

    public LinkedList<Integer> Reverse(LinkedList<Integer> stack) {
        LinkedList<Integer> tempStack = new LinkedList<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        return tempStack;
    }

    public synchronized void printStack() {
        ListIterator<Integer> iterator;
        if (transactionStack.get().isEmpty() && !threadFlag.get()) {
            System.out.println("Using stack");
            iterator = stack.listIterator();
        } else {
            System.out.println("Using t_stack");
            iterator = transactionStack.get().listIterator();
        }
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
    }

    public synchronized int count() {
        return stack.size();
    }
}