import java.util.Arrays;

/* The running time for binary search is still lgN for an unordered array, because
 * the length hi - lo is still guaranteed halve with each iteration. The algorithm will
 * in general return incorrect results though, because the fundamental assumption that
 * the items are sorted is violated. You should never check whether the entire array
 * is in ascending order each time a call is made to the search, because that is an inherently
 * linear time operation, meaning the search will now also be linear time (and therefore
 * now on equal footing with a brute-force search). 
 * 
 * We can at least do the following sanity check on whether the subset of elements considered 
 * in the array are in the correct order, but this is not guaranteed to pick up any problems. 
 * All elements in the array range should compare the same way as the key did with the previous
 * midpoint item, so checking this for the current midpoint item is one way of partially testing this.
 */

public class CheckingBinarySearch {
  
  // return the index of the key in the sorted array a[]; -1 if not found
  public static int search(String key, String[] a) {
    return search(key, a, 0, a.length, 0, "");
  }
  
  public static int search(String key, String[] a, int lo, int hi, int lastCmp, String lastItem) {
    // possible key indices in [lo, hi)
    if (hi <= lo) return -1;
    int mid = lo + (hi - lo) / 2;
    int checkCmp = lastItem.compareTo(a[mid]);
    if ((lastCmp != 0) // false if the last call was from the top method => do no check.
        && (checkCmp != 0) // last item equal to current means they are in sorted order by definition
        && (Math.signum(checkCmp) != Math.signum(lastCmp))) // Do the comparison signs differ?
      throw new RuntimeException("Array passed to binary search contained unsorted items " + lastItem + " and " + a[mid]);

    int cmp = a[mid].compareTo(key);
    if      (cmp > 0) return search(key, a, lo, mid, cmp, a[mid]);
    else if (cmp < 0) return search(key, a, mid+1, hi, cmp, a[mid]);
    else              return mid;
  }


    public static void main(String[] args) {
      String[] sorted = {"aaa", "bbb", "ccc", "ddd", "eee"};
      System.out.println(search("ccc", sorted));
      System.out.println(search("e", sorted));
 
      String[] unsorted = {"eee", "ccc", "ggg", "bbb", "fff", "ddd", "aaa"};
      System.out.println(search("ddd", unsorted)); 
      // The items checked are "bbb" and "ddd", which are in the correct order.
      // So the unsorted array isn't picked up.
      
      System.out.println(search("aaa", unsorted));
      // Here, the items checked are "bbb" and "ccc", which are in incorrect order, so the
      // function throws an exception.
    }
}

