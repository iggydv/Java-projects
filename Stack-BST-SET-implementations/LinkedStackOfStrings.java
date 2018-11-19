
/*************************************************************************
 *  Compilation:  javac LinkedStackOfStrings.java
 *  Execution:    java LinkedStackOfStrings
 *
 *  A stack of strings, implemented using a linked list.
 *  
*  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java LinkedStackOfStrings < tobe.txt 
 *  to be not that or be
 *  
 *************************************************************************/


public class LinkedStackOfStrings {
    private int N;          // size of the stack
    private Node first;     // top of stack

    // helper Node class
    private class Node {
        private String item;
        private Node next;
    }

    // is the stack empty?
    public boolean isEmpty() { return first == null; }

    // number of elements on the stack
    public int size() { return N; }


    // add an element to the stack
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
    
    public static boolean find(LinkedStackOfStrings stack, String key)
    {
      for(Node current = stack.first ; current != null ; current = current.next)
      {
        if(key.compareTo(current.item)==0)
          return true;
      }
          return false;
      
    }
//
//    public static boolean find(LinkedStackOfStrings stack, String key) {
//      for (Node current = stack.first; current != null ; current = current.next) {
//        if (key.compareTo(current.item) == 0) return true;
//      }
//      return false;
//    }
    
    public boolean find(String key) {
      return find(this, key);
    }

        public void removeAfter(Node node) {
          
          if(node == null) return;
          if(node.next == null) return;
          node.next = node.next.next;
//      if (node == null) return; // Do nothing
//      if (node.next == null) return; // There is no next node to delete;
//      node.next = node.next.next;
    }
    
    public void delete(int pos) {
      if((pos == 0) && (first != null))
      {
        first = first.next;
          return;
      }
      
      Node current = first;
      while ((pos > 1) && (current != null))
      {
        current = current.next;
        pos--;
      }
      
      removeAfter(current);
      
//      if ((pos == 0) && (first != null)) {
//        first = first.next;
//        return;
//      }
//      
//      Node current = first;
//      while ((pos > 1) && (current != null)) {
//        current = current.next;
//        pos--;
//      }
//      removeAfter(current);
    }
    
    public void insertAfter(Node n, Node newNode) {
      if((n == null) || (newNode == null)) return;
      Node oldnext = n.next;
      n.next = newNode;
      newNode.next = oldnext;
      
//      if ((n == null) || (newNode == null)) return;
//      Node oldNext = n.next; // Store n's old follower
//      n.next = newNode;
//      newNode.next = oldNext;
    }

    public void insertAfter(int pos, String item) {
      Node current = first;
      while ((pos > 0) && (current != null)) {
        current = current.next;
        pos--;
      }
      if (current == null) return;
      Node newNode = new Node();
      newNode.item = item;
      insertAfter(current, newNode);
    }
    
    public String toString() {
      StringBuilder result = new StringBuilder();
      for (Node current = first ; current != null ; current = current.next)
        result.append(current.item + " ");
      
      return result.toString();
    }
    
    // test client
    // Type in strings to push onto stack
    // - to pop from stack
    // find followed by a string will print true if the string is there, false if not.
    // insertafter takes an integer position and inserts the subsequent string using insertAfter into the list.
    // delete followed by an integer will delete the node at that position, if there is one.
    // at each turn, the entire stack is printed.
    public static void main(String[] args) {
        LinkedStackOfStrings s = new LinkedStackOfStrings();
        while (!StdIn.isEmpty()) {
          String item = StdIn.readString();
          if (item.equals("find")) System.out.println(s.find(StdIn.readString()));
          else if (item.equals("insertafter")) s.insertAfter(StdIn.readInt(),StdIn.readString());
          else if (item.equals("delete")) s.delete(StdIn.readInt());
          else if (!item.equals("-")) s.push(item); 
          else if (s.isEmpty())  StdOut.println("BAD INPUT"); 
          else                   StdOut.print(s.pop());
          System.out.println("Current stack from top: " + s.toString());
        } 
    } 
}
