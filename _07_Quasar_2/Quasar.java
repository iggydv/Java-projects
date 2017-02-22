public class Quasar
{
  public static void main(String[] args)
  {
    
    int score = 1;
    int payout = 0;
    System.out.println("Your current score is: "+score);
    while(score<=20)
    {
      
      if(score<15)
      {
        payout = 0;
      }
      else if(score==16)
      {
        payout = 100;
      }
      else if(score==17)
      {
        payout = 200;
      }
      else if(score==18)
      {
        payout = 250;
      }
      else if(score==19)
      {
        payout = 300;
      }
      else if(score==20)
      {
        payout = 400;
      }
      
      System.out.println("Do you want to:");
      System.out.println("(1) Add 1-8");
      System.out.println("(2) Add 4-7");
      System.out.println("(3) Stop");
      System.out.println("Current payout is: "+payout);
      
      
      int choice = Integer.parseInt(StdIn.readLine());
      
      if(choice == 1)
      {
        int random = (int)(Math.random()*8+1);
        System.out.println("You rolled "+random);
        score = score + random;
      }
      else if(choice == 2)
      {
        int random = (int)(Math.random()*3+5);
        System.out.println("You rolled "+random);
        score = score + random;
      }
      else if(choice == 3)
      {
        System.out.println("You've won "+payout+" Credits");
        break;
      }
      else
      {
          System.out.println("<<<INVALID OPTION>>>");
      }
      
      
      System.out.println("Your current score is: "+score);
      
      
      
      
      if(score > 20)
      {
        System.out.println("You've won 0 Credits");
        
      }
    }
  }
}