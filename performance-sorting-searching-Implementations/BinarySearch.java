// Note that we have replaced String with Integer, but the principle remains the same.

import java.util.Arrays;

public class BinarySearch {

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(Integer key, Integer[] a) 
    {
        return search(key, a, 0, a.length);
    }
    
    
    public static int search(Integer key, Integer[] a, int lo, int hi) 
    {
      assert (hi >= lo); // We now require hi and lo to be in the correct order, or equal.
      if (hi == lo) return -hi; // We haven't found the key
      int mid = lo + (hi - lo) / 2;
      int cmp = a[mid].compareTo(key);
      if (cmp == 0) {
        // Okay, we've found ONE instance of the key in the array, but there might be more to the left.
        // So we still search the left interval, looking the item.
        int result = search(key, a, lo, mid);
        if ((result >= 0) && (a[result] == key)) {
          // We have to test a[result] == key because of the ambiguity for result == 0.
          // We found the key further left as well. Return THAT index instead.
          return result;
        }
        // Nope, no key to the left. We return the position of the one we found instead!
        return mid;
      }
      else if (cmp > 0) return search(key, a, lo, mid);
      // this else if (cmp < 0)!
      else return search(key, a, mid+1, hi); 
    }

    // A brute force implementation for testing against in the test client
    public static int bruteforce(Integer key, Integer[] a) {
      for (int i = 0 ; i < a.length ; i++) {
        int cmp = a[i].compareTo(key);
        if (cmp == 0) return i;
        else if (cmp > 0) return -i;
      }

      return -a.length;
    }
    
    // whitelist, exception filter
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

