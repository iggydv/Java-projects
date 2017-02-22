public class OOG
{
  public static int distinct(int[] a) {
    int N = a.length;
    int count = 0;
    for (int i = 0; i < N; i++) {
      boolean distinct = true;
      for (int j = i+1; j < N; j++) {
        if (a[i] == a[j]) distinct = false;
      }
      if (distinct) count++;
    }
    return count;
  }
  
  public static void main(String [] args)
  {
    
    int [] arr = {4,5,6,7,5};
    int a = 0;
    
    int count = distinct(arr);
    StdOut.println(count);
  }
}