public class MRU {
    private Node first;     // top of stack

    // helper Node class
    private class Node {
        private char item;
        private Node next;
    }

    public MRU() {
      first = null;
    }
    
    public void insert(char x) {
      Node lastNode = null;
      Node current = first;
      while (current != null) {
        if (current.item == x) {
          if (lastNode == null) return; // this is already at the start of the list, do nothing
          lastNode.next = current.next; // delete node from current position.
          current.next = first;         // set the current node to point to the starting node
          first = current;              // set the current node to be the new start
          return;
        }
        lastNode = current;
        current = current.next;
      }
      // Alas, we have not found the character, we must insert a new node.
      Node oldFirst = first;
      first = new Node();
      first.item = x;
      first.next = oldFirst;
    }
    
    public String toString() {
      StringBuilder result = new StringBuilder();
      for (Node current = first ; current != null ; current = current.next)
        result.append(current.item + " ");
      
      return result.toString();
    }
    
    public static void main(String[] args) {
      MRU mru = new MRU();
      while (!StdIn.isEmpty()) {
        System.out.println("MRU characters: " + mru.toString());
        char in = StdIn.readChar();
        mru.insert(in);
        System.out.println("Inserting " + in);
      }
    }
}