public class MakeADeal
{
  public static void main(String[] args)
  {
    double N = Double.parseDouble(args[0]);
    System.out.println("Running "+N+" simulations.");
    
   
    
    for(int a = 0 ;a<N;a++)
    {
      System.out.println("Choose a Door:\nDoor1->(0) / Door2->(1) / Door3->(2)\n------------------------------------");
      int winning = (int)(Math.random()*3);
      System.out.println("WINNING DOOR: "+winning);
      //doors closed
      boolean door1 = false;
      boolean door2 = false;
      boolean door3 = false;
      
      //winning door can't be opened - contains prize
      switch(winning){
        case 0: door1 = true; break;
        case 1: door2 = true; break;
        case 2: door3 = true; break;
      }
      
      int choice = Integer.parseInt(StdIn.readLine());
      while(choice>2)
      {
        System.out.println("*****ERROR - invalid option*****");
        choice = Integer.parseInt(StdIn.readLine());
      }
      //door can't be opened
      switch(choice){
        case 0: door1 = true; break;
        case 1: door2 = true; break;
        case 2: door3 = true; break;
      }
      
      int OpenDoor = 0;
      
      //says which door to show, then makes it unavailible for last choice
      if(door1 == false)
      {
        OpenDoor = 0;
        door1 = true;
      }
      else if(door2 == false)
      {
        OpenDoor = 1;
        door2 = true;
      }
      else if(door3 == false)
      {
        OpenDoor = 2;
        door3 = true;
      }
      
      //last choice, door which is still unselected
      int Lastchoice = -1;
      
      //let the winning door be an option if the first choice wasnt the winning door.
      switch(winning){
        
        case 0: door1 = false; break;
        case 1: door2 = false; break;
        case 2: door3 = false; break;
      }
      switch(choice){
       
        case 0: door1 = true; break;
        case 1: door2 = true; break;
        case 2: door3 = true; break;
      }
     
      if(door1 == false)
      {
        Lastchoice = 0;
        
      }
      
      else if(door2 == false)
      {
        Lastchoice = 1;
        
      }
      
      else if(door3 == false)//false
      {
        Lastchoice = 2;
        
      }
      
      
      System.out.println("winning_door="+winning+" first_pick="+choice+" opened_door="+OpenDoor+" other_choice="+Lastchoice);
      if(choice == winning)
        System.out.println("First Pick wins!");
      else if(Lastchoice == winning)
        System.out.println("Other choice wins!");
      
      
    }
    double prob1 = 1/N;
      double prob2 = (N-1)/N;
      System.out.println("Probability of win if stays: "+prob1);
      System.out.println("Probability of win if changes: "+prob2);
  }
}