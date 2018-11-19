public class Rhymer {
  public static String reverse(String str) {
    StringBuilder result = new StringBuilder();
    for (int i = str.length() - 1 ; i >= 0 ; i--) {
      result.append(str.charAt(i));
    }
    return result.toString();
  }
  
  public static void main(String args[]) {
    In dict = new In(args[0]);
    String[] words = dict.readAllStrings();
    for (int i = 0 ; i < words.length ; i++) {
      words[i] = reverse(words[i]);
    }
    Merge.sort(words);
    for (int i = 0 ; i < words.length ; i++) {
      words[i] = reverse(words[i]);
      System.out.println(words[i]);
    }    
  }
}