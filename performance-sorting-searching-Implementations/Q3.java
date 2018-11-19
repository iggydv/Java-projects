
public class Q3
{


  public static void main(String[] args)
  {
   
    Stopwatch s = new Stopwatch();
   
    int N = StdIn.readInt();
    double[][] c = new double[N][N];
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == j) c[i][j] = 1.0;
        else c[i][j] = 0.0;
      }
    }
    double ss = s.elapsedTime();
    StdOut.print(ss);
  }
  
  
  
}