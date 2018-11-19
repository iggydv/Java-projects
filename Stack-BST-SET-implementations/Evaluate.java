
public class Evaluate {
  public static boolean evaluate(BST<String,Boolean> vars, String expr) {
    expr = expr.trim();
    String[] tokens = expr.split(" ");
    Stack<String> ops  = new Stack<String>();
    Stack<Boolean> vals = new Stack<Boolean>();

    for (String s : tokens) {
      if      (s.equals("("))               ;
      else if (s.equals("&&"))    ops.push(s);
      else if (s.equals("||"))    ops.push(s);
      else if (s.equals("!"))    ops.push(s);
      else if (s.equals(")")) {
        String op = ops.pop();
        boolean v = vals.pop();
        if      (op.equals("&&"))    v = vals.pop() && v;
        else if (op.equals("||"))    v = vals.pop() || v;
        else if (op.equals("!"))    v = !v;
        vals.push(v);
      }
      else vals.push(vars.get(s));
    }
    return vals.pop();
  }
  
  public static void main(String args[]) {
    BST<String,Boolean> vars = new BST<String,Boolean>();
    while (!StdIn.isEmpty()) {
      String line = StdIn.readLine().trim();
      if ((line.length() >= 4) && (line.substring(0,4).equals("eval"))) {
        System.out.println(evaluate(vars, line.substring(4)));
        continue;
      }
      String[] items = line.split(" ");
      if (items.length != 2) System.out.println("Error, only two items allowed for a variable setting line.");
      else {
        String var = items[0];
        Boolean val = Boolean.parseBoolean(items[1]);
        vars.put(var, val);
      }
    }
  }
}
