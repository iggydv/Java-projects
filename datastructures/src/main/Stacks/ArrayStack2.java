import java.util.EmptyStackException;
 public class ArrayStack2 {

    private int[] stack;
    private int top;

    public ArrayStack2(int capacity) {
        stack = new int[capacity];
    }

    public void push(int value) {
        if (top == stack.length) {
            // need to resize the backing array
            int[] newArray = new int[2*stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = value;
    }

    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stack[--top];
        stack[top] = 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}