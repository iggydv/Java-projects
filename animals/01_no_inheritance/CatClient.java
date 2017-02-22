public class CatClient
{
  public static void allNoises(Cat[] cats)
  {
    for (int i = 0 ; i < cats.length ; i++) {
      cats[i].makeNoise();
    }
  }
  
  public static void main(String foo[])
  {
    Cat[] cats = {new Cat("Felix"), new Cat("Mr. Bigglesworth"), new Cat("Sylvester")};   
    
    // This line would generate an `incompatible type' error when compiling
    // Cat[] cats = {new Dog("Fido"), new Cat("Mr. Bigglesworth"), new Cat("Sylvester")};   

    allNoises(cats);
  }
}