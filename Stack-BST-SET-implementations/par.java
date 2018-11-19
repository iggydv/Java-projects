public class par{

  public static void main(String [] args)
  {
    Stack<Character> brackets = new Stack<Character>();
    while(!StdIn.isEmpty())
    {
      char in = StdIn.readChar();
      if((in == '(') || (in == '[') || (in == '{'))
        brackets.push(in);
      
      if((in == ')' ) && ((brackets.isEmpty()) || (brackets.pop() != '(')))
      {
        StdOut.println("false");
        return;
                        
      }
      if((in == ']' ) && ((brackets.isEmpty()) || (brackets.pop() != '[')))
      {
        StdOut.println("false");
        return;
                        
      }
      if((in == '}' ) && ((brackets.isEmpty()) || (brackets.pop() != '{')))
      {
        StdOut.println("false");
        return;
                        
      }
    }
    if(brackets.size()!= 0)
    {
      StdOut.println("false");
      return;
    }
      StdOut.println("true");
  }
}