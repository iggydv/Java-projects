public class Dog extends Animal
{
  public Dog(String myName)
  {
    super(myName);
  }
  
  public void makeNoise()
  {
    System.out.println(getName() + " goes " + "Woof!");
  }
}