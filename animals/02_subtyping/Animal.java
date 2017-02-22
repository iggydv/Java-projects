public class Animal
{
  String myName;
  
  protected Animal()
  {
    System.out.println("A new animal has been created!");
  }
  
  public Animal(String name)
  {
    System.out.println("A new animal called " + name + " has been created!"); 
    myName = name;
  }

  public String getName()
  {
    return myName;
  }
  
  public void makeNoise()
  {
    System.out.println(getName() + " makes a noise!");
  }
}