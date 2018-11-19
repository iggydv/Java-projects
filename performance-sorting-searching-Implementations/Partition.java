public class Partition {
  // Exchange items at position i and j in arr.
  public static void exch(Comparable[] arr, int i, int j) {
    Comparable temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static void partition(Comparable[] arr) {
    if (arr.length == 0) return;
    
    int left = 0;
    int right = arr.length;

    // We need to first find the minimum element.
    Comparable min = arr[0];
    for (int i = 1 ; i < arr.length ; i++) {
      int cmp = min.compareTo(arr[i]);
      if (cmp < 0) {
        // The first element was the minimum element, so we have a sorted array up to i-1!
        left = i - 1;
        break;
      } else if (cmp > 0) {
        // The first element was not the minimum element, we need to start over :(
        left = 0;
        min = arr[i];
        break;
      }
    }

    while (left != right) {
      if (arr[left].compareTo(min) != 0) {
        right--;
        exch(arr, left, right);
      } else left++;
    }
  }
}