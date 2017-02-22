public class ArrayStackOfStrings
{
  private String [] a;
  private int N;
  private int max;
  
  public ArrayStackOfStrings( int max)
  {
    a  = new String[max];
    this.max = max;
  }
  
  boolean isEmpty()
  {
    return (N ==0);
  }
  
  public void push(String item)
  { 
    a[N++] = item;
  }
  
  public String pop(String item)
  {
    return a[--N];
  }
  
  public boolean isFull()
  {
    return (a[max-1] != null);
  }
}