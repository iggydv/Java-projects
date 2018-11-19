
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueueOfStrings implements Iterable<String> {
  private int max;
  private String[] a;      // holds the items
  private int N;           // number of queued items
  private int front;       // index of the front of the queue
  private int back;        // index after the back of the queue
  
    public ArrayQueueOfStrings(int max) {  
      this.max = max;
      a = new String[max];    
      N = 0;
    }
    
    public boolean isEmpty()            {  
      return (N == 0);           
    }
    
    public boolean isFull() {
      return (N == max);
    }
    
    public void enqueue(String item)       {
      if (isFull()) throw new RuntimeException("Queue is full");
      a[back++] = item;             
      back = back % max;
      N++;
    }
    
    public String dequeue() {  
      if (isEmpty()) throw new NoSuchElementException("Queue is empty");
      String item = a[front++];
      front = front % max;
      N--;
      return item;
    }
    
    public Iterator<String> iterator()  { 
      return new ArrayIterator(); 
    }
    
    public class ArrayIterator implements Iterator<String> {
        private int i = 0;

        public boolean hasNext() { 
          return i != N; 
        }
        public String next()     {
          if (!hasNext()) throw new NoSuchElementException("Queue iterator has no more items.");
          String item = a[(front + i) % max];
          i++;
          return item; 
        }
        public void remove()      { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        ArrayQueueOfStrings queue = new ArrayQueueOfStrings(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
              if (queue.isFull()) StdOut.println("QUEUE FULL");
              else queue.enqueue(item); 
            }
            else if (queue.isEmpty())  StdOut.println("BAD INPUT"); 
            else                       StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left in queue: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    } 
} 

