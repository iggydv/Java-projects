public class Cat extends Animal
{  
  public Cat(String myName)
  {
    super(myName);
  }
  
  public void makeNoise()
  {
    System.out.println(getName() + " goes " + "Meow!");
  }
}