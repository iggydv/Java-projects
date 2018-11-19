import java.util.Arrays;

public class IGsearch
{
  public static void search(Integer key, Integer [] a)
  {
    search(key, a, 0, a.length);
  }
  
  public static int search(Integer key, Integer [] a, int lo, int hi)
  {
   
    assert(hi>=lo);
    if(hi == lo)
    {
      return -hi;
    }
    int mid = lo + (hi - lo)/2;
    int cmp = a[mid].compareTo(key);
    if(cmp == 0)
    {
      int result = search(key, a, 0, mid);
       if((result >= 0)&&(a[result] == key))
       {
          return result;
       }
       else
         return mid;
    }
    
    else if (cmp > 0)
    {
      return search(key, a, lo, mid);
    }
    else
      return search(key, a , mid+1, hi);
    
  }
  
  //brute force
  public static int bruteforce(Integer key, Integer[] a) {
      for (int i = 0 ; i < a.length ; i++) {
        int cmp = a[i].compareTo(key);
        if (cmp == 0) return i;
        else if (cmp > 0) return -i;
      }

      return -a.length;
    }
  
  public static void main(String[] args) {
      for (int i = 0 ; i < 100000 ; i++) { // Generates test cases and compares binary search with brute force
        int maxElement = StdRandom.uniform(20);
        int size = StdRandom.uniform(20);
        Integer[] arr = new Integer[size];
        for (int j = 0 ; j < size ; j++) {
          if (maxElement != 0) {
            arr[j] = StdRandom.uniform(maxElement);  // Only takes positive arguments :/
          } else {
            arr[j] = 0;
          }
        }
        int find = StdRandom.uniform(-3, maxElement + 3);
        Arrays.sort(arr);
        /* Debugging output
        for (int j = 0 ; j < size ; j++) {
          System.out.print(arr[j] + " ");
        }
        System.out.println(" : searching for " + find); */
        if (bruteforce(find, arr) != search(find, arr))
          throw new RuntimeException("Mismatch!");
      }
    }
  
}
  
  
  
      
    
    
