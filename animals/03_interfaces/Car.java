public class Car implements Noisy
{  
  public Car()
  {
    System.out.println("A new car has been manufactured.");
  }
  
  public void makeNoise()
  {
    System.out.println(this + " goes Vrooom!");
  }
}