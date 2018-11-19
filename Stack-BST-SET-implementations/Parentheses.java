public class Parentheses 
{
  
  public static void main(String args[]) {
    Stack<Character> brackets = new Stack<Character>();
    while (!StdIn.isEmpty()) {
      char in = StdIn.readChar();
      if ((in == '(') || (in == '[') || (in == '{')) brackets.push(in);
      if ((in == ')') && (brackets.isEmpty() || brackets.pop() != '(')) { 
        // We have found a closing ), but either there was no opening bracket, or the opening bracket
        // was of another type.
        System.out.println("false"); 
        return; 
      }
      if ((in == ']') && (brackets.isEmpty() || brackets.pop() != '[')) { 
        // We have found a closing ], but either there was no opening bracket, or the opening bracket
        // was of another type.
        System.out.println("false"); 
        return; 
      }
      if ((in == '}') && (brackets.isEmpty() || brackets.pop() != '{')) { 
        // We have found a closing }, but either there was no opening bracket, or the opening bracket
        // was of another type.
        System.out.println("false"); 
        return; 
      }
    }
    if (brackets.size() != 0) {
      System.out.println("false"); // Some brackets were not matched by closing ones
      return;
    }
    System.out.println("true");
  }
}