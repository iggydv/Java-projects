public class BoysAndGirls
{
  public static void main(String[] args)
  {
    double N = Double.parseDouble(args[0]);
    System.out.println("Running "+N+" simulations.");
    boolean found = false;
    int boys = 0;
    int girls = 0;
    int totalCount = 0;
    
    int TWOc = 0;
    int THREEc = 0;
    int FOURc = 0;
    int FIVEPLUSc = 0;
    
    for(int a = 0 ;a<N;a++)
    {
      boolean G = false;
      boolean B = false;
      found = false;
      String sex = "";
      String girlsBoys = "";
      int count =0;
      
      while(found==false)
      {
      double child = Math.random();
      
      if(child<0.5)
      {
        sex = "boy ";
        girlsBoys = girlsBoys + sex;
        boys++;
        count++;
        B = true;
      }
      else
      {
        sex = "girl ";
        girlsBoys = girlsBoys + sex;
        girls++;
        count++;
        G = true;
      }
      
      if((B==true)&&(G==true))
      found = true;
      
      }
      if(count ==2)
        TWOc++;
      
      else if(count ==3)
        THREEc++;
      
      else if(count ==4)
        FOURc++;
      
      else
        FIVEPLUSc++;
      
      totalCount = totalCount+count;
     
      System.out.println(girlsBoys+"count="+count);
      
    }
    System.out.println("Boys: "+boys+" Girls: "+girls);
    System.out.println("Probability of having 2 children: "+TWOc/N);
    System.out.println("Probability of having 3 children: "+THREEc/N);
    System.out.println("Probability of having 4 children: "+FOURc/N);
    System.out.println("Probability of having 5 or more children: "+FIVEPLUSc/N);
  }
}