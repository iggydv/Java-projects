public class DogClient
{
  public static void allNoises(Dog[] dogs)
  {
    for (int i = 0 ; i < dogs.length ; i++) {
      dogs[i].makeNoise();
    }
  }

  public static void main(String foo[])
  {
    Dog[] dogs = {new Dog("Fido"), new Dog("Wagter"), new Dog("Rover")};   
    
    // This line would generate an `incompatible type' error when compiling
    // Dog[] dogs = {new Cat("Felix"), new Dog("Wagter"), new Dog("Rover")};   

    allNoises(dogs);
  }
}