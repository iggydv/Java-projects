public class Cat
{
  private String myName;
  
  private Cat()
  {
    
  }
  
  public Cat(String name)
  {
    myName = name;
  }

  public String getName()
  {
    return myName;
  }
  
  public void makeNoise()
  {
    System.out.println(getName() + " goes Meow!");
  }
}