public class AnimalClient
{
  public static void allNoises(Animal[] animals)
  {
    for (int i = 0 ; i < animals.length ; i++) {
      animals[i].makeNoise();
    }
  }
  
  public static void main(String foo[])
  {
    Animal[] animals = {new Cat("Felix"), new Dog("Fido"), new Cat("Sylvester")};   
    
    // This line would generate an `incompatible type' error when compiling
    // Animal[] animals = {new Car(), new Dog("Fido"), new Cat("Sylvester")};   

    allNoises(animals);
  }
}                        
