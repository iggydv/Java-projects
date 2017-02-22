public class Merge {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length);
    } 

    // Sort a[lo, hi). 
    public static void sort(Comparable[] a, int lo, int hi) {
        int N = hi - lo;        // number of elements to sort

        // 0- or 1-element file, so we're done
        if (N <= 1)
        {
          
          return; 
        }
        // recursively sort left and right halves
        int mid = lo + N/2; 
        sort(a, lo, mid); 
        sort(a, mid, hi); 

        // merge two sorted subarrays
        Comparable[] aux = new Comparable[N];
        int i = lo, j = mid;
        for (int k = 0; k < N; k++) {
            if      (i == mid)  aux[k] = a[j++]; // if you run out of items in left list
            else if (j == hi)   aux[k] = a[i++]; // if you run out of items in right list
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else                               aux[k] = a[i++];
        }

        // copy back
        for (int k = 0; k < N; k++) {
            a[lo + k] = aux[k]; 
        }
    }
    
    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        Merge.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}