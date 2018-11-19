public class SetOps {
  public static SET<String> setminus(SET<String> a, SET<String> b) {
    SET<String> result = new SET<String>();
    for (String s : a) {
      if (!b.contains(s)) result.add(s);
    }
    return result;
  }
  
  public static String setToString(SET<String> set) {
    StringBuilder result = new StringBuilder();
    result.append("{");
    int left = set.size();
    for (String s : set) {
      result.append(s);
      left--;
      if (left != 0) result.append(" ");
    }
    result.append("}");
    return result.toString();
  }
  
  public static SET<String> symmdiff(SET<String> a, SET<String> b) {
    return setminus(a.union(b), a.intersects(b)) ;    
  }
  
     public static void main(String[] args) {
        SET<String> A = new SET<String>();
        SET<String> B = new SET<String>();

        // insert some keys into A
       for (String s : new String[]{"a", "b", "c", "d", "e", "f", "g"}) {
         A.add(s);
       }

        // insert some keys into B
       for (String s : new String[]{"a", "c", "e", "g", "x", "y", "z"}) {
         B.add(s);
       }
       System.out.println("A = " + setToString(A));
       System.out.println("B = " + setToString(B));

       System.out.println("A\\B = " + setToString(setminus(A,B)));
       System.out.println("B\\A = " + setToString(setminus(B,A)));
       
       System.out.println("symmdiff(A,B) = " + setToString(symmdiff(A,B)));
       System.out.println("symmdiff(B,A) = " + setToString(symmdiff(B,A)));       
     }
}