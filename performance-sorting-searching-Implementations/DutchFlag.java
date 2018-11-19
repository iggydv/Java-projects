public class DutchFlag {
  // Exchange items at position i and j in arr.
  public static void exch(Comparable[] arr, int i, int j) {
    Comparable temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  // Finds the minimum element in the array starting from start, and partitions the array
  // so that all elements equal to the minimum are placed just after start. The index just
  // after the minimum elements is returned for use in flag.
  public static int partition(Comparable[] arr, int start) {
    if ((arr.length - start) == 0) return -1;
    
    // We need to first find the minimum element.
    Comparable min = arr[start];
    for (int i = start+1 ; i < arr.length ; i++) {
      int cmp = min.compareTo(arr[i]);
      if (cmp > 0) {
        // We have found a new minimum
        min = arr[i];
      }
    }
    
    int left = start;
    int right = arr.length;
    while (left != right) {
      if (arr[left].compareTo(min) != 0) {
        right--;
        exch(arr, left, right);
      } else left++;
    }
    return left;
  } 
  
  public static void dutchFlag(Comparable[] arr) {
    int index = partition(arr, 0);
    if (index != -1) partition(arr, index);
  }
}