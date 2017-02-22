public class Dog
{
  private String myName;
  
  private Dog()
  {
    
  }
  
  public Dog(String name)
  {
    myName = name;
  }

  public String getName()
  {
    return myName;
  }
  
  public void makeNoise()
  {
    System.out.println(getName() + " goes " + "Woof!");
  }
}