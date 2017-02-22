public class CoinToss
{
  public static void main(String[] args)
  {
    double N = Double.parseDouble(args[0]);
    System.out.println("Running "+N+" simulations.");
    double AVG = 0.0;
    int won = 0;
    for(int a=0;a<N;a++)
    {
      boolean flag1 = false;
      boolean flag2 = false;
      
      boolean HEAD = false;
      boolean TAIL = false;
      boolean headsTails = false;
      
      int heads = 0;
      int HT = 0;
      
      int countA = 0;
      int countB = 0;
      
      String ALICE = "";
      String BOB = "";
      
      while(flag1==false)
      {
        double ran = Math.random();
        if(ran<0.5)
        {
          ALICE = ALICE+"H";
          heads++;
          
        }
        else
        {
           ALICE = ALICE+"T";
          heads = 0;
          
        }
        if(heads==2)
        {
          flag1 = true;
        }
         countA++;
      }
      
      while(flag2==false)
      {
        double ran = Math.random();
        if(ran<0.5)
        {
          BOB = BOB+"H";
          HEAD = true;
        }
        else
        {
          BOB = BOB+"T";
          TAIL = true;
          if(HEAD==true)
          {
            headsTails = true;
          }
          else
          {
            HEAD = false;
            TAIL = false;
          }
        }
        if(headsTails==true)
        {
          flag2 = true;
        }
        countB++;
      }
      
      System.out.println("Alice: "+ALICE+" BOB: "+BOB);
      if(countA<countB)
      {
        System.out.println("<<<<Alice has fewer>>>>");
        won++;
      }
    }
    AVG = won/N;
    System.out.println(AVG);
  }
}