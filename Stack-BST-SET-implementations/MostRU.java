public class MostRU{
  private Node first;
  
  public class Node
  {
    private char item;
    private Node next;
  }
 
  public MostRU(){
    first = null;
  }
  
  public void insert(char x)
  {
    
    Node lastNode = null;
    Node current = first;
    
    while(current != null)
    {
      if(current.item == x)
      {
        if(lastNode == null) return;
        lastNode.next = current.next;
        current.next = first;
        first = current;
      }
      lastNode = current;
      current = current.next; 
    }
    
    Node oldfirst = first; //kry eerste Node
    first = new Node(); // skep nuwe Node
    first.item = x;
    first.next = oldfirst;
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
  
  
  
  
  