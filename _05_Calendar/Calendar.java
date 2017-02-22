public class Calendar
{
  public static void main(String[] args)
  {
    int m = 0;
    int y = 0;
    
    int n =0;
    int y0 = 0;
    int x = 0;
    int m0 = 0;
    int d0 = 0;
    int d = 1;
    String Month = "";
    boolean LY = false;
    
    
    m = Integer.parseInt(args[0]);
    y = Integer.parseInt(args[1]);
    
    if((m<=0)||(y<=0))
    {
      System.out.println("Invalid year or Month");
      System.Exit();
    }
    
    y0 = y - (14 - m)/12;
    x = y0 = y0/4 - y0/100 + y0/400;
    m0 = m + 12*((14-m)/12)-2;
    d0 = (d + x + (31*m0)/12)%7;
    
      
    if((y%4==0)&&(y%100!=100))
      LY = true;

    else if((y%400==0)&&(y%100==0))
      LY = true;
    
    else if(y%400==0)
      LY = true;
    
    switch(m)
    {
      case 1: {Month = "January"; n =31;} break; 
      case 2: {Month = "February"; if(LY==true){n=29;}else{n=28;}} break; 
      case 3: {Month = "March";n =31;} break; 
      case 4: {Month = "April";n=30;} break; 
      case 5: {Month = "May";n =31;} break; 
      case 6: {Month = "June";n=30;} break; 
      case 7: {Month = "July";n =31;} break; 
      case 8: {Month = "August";n =31;} break; 
      case 9: {Month = "September";n=30;} break; 
      case 10: {Month = "October";n =31;} break; 
      case 11: {Month = "November";n=30;} break; 
      case 12: {Month = "December";n =31;} break; 
      
    }
    
   System.out.println(Month +" "+ y);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nS\tM\tTu\tW\tTh\tF\tS\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    for(int a = 0; a < n ;a++)
    {
      System.out.print((a+1)+"\t");
      if((a+1)%7==0)
      {
        System.out.println();
      }
    }
    
   
    
    
  }
}