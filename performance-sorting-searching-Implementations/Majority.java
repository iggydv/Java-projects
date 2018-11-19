public class Majority {
  // To see why this approach works, we do not need to consider the case where there is NOT a majority,
  // because that is caught at the end by the linear pass through the array (checking whether the candidate 
  // in fact has a majority).
  // See the original paper in which the algorithm was published:
  // http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.56.3439&rep=rep1&type=pdf
  // Interestingly, the paper also includes a discussion of an automated proof process that demonstrated
  // that the authors' FORTRAN implementation is mathematically correct.
  
  public static Integer majority(Integer[] arr)
  {
    if (arr.length == 0)
      return null; // no majority
    Integer candidate = null;
    int count = 0;
    for (int i = 0; i < arr.length ; i++ )
    {
      if (count == 0)
      {
        candidate = arr[i];
        count = 1;
      } 
      else if (candidate.compareTo(arr[i]) == 0)
        count++;
      
      else count--;
    }
    
    count = 0;
    for (int i = 0 ; i < arr.length ; i++)
    {
      if (candidate.compareTo(arr[i]) == 0) count++;
    }
    if (count > arr.length / 2)
      return candidate;
    
    else return null;
  }
}