import java.util.HashMap;
public class BasicHashMaps
{
  /*first things first die maps word hier as static verklaar 
   *omdat ons die map in 'n static main method gaan gebruik
   * so dis nie noodwendig altyd nodig om jou hashmap as
   * static te verklaar nie.
   * 
   * okay here we go :D 
   */
  
  
  //net 'n gewone hashMap waar integers (ints) gemap word
  //---------------------------------------------------------
  static HashMap<String, Integer> basic = new HashMap<String, Integer>();
  //static HashMap<String, int> basic = new HashMap<String, int>(); gewone 'int' sou nie werk nie soek 'Integer'
  //---------------------------------------------------------
  
  
  
  //hashmap waar Human objects gemap word
  //---------------------------------------------------------
  static HashMap<String, Human> map = new HashMap<String, Human>(); 
  //---------------------------------------------------------
  
  
  
  /* Net hoe 'n HashMap werk.
   * ------------------------
   * Dit het 'n key en 'n value, HashMap<key, Value>
   * (1) die value is gemap na die key, dws die key stel die value voor
   * 
   * (2) die verskil tussen HashMap en Hash table ->
   *     HashMap - unsynchronized (concurrent) en laat 'null' values toe in die map
   *     Hastable - Synchronized en laat nie 'null' values toe in die table
   *     hulle werk basically dieselfde
   *     (ek sal vir jou verduidelik wat dit beteken, maar moet nie te veel daaroor worry nie)
   * 
   * (3) as daar twee key values is wat dieselfde is, word die een override.
   *     dws net die nuutste een bestaan.
   * 
   * Die maps word soos 'n array amper gebruik, baie dieselfde konsep
   * 
   * */
  
  
  
  
  public static void main(String[] args)
  {
     //----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------
    System.out.println("Using the 'basic' HashMap");
    System.out.println("---------------------------");
    basic.put("one", 1);
    basic.put("two", 2);
    basic.put("seven", 7);
    
    System.out.println(basic); //wys vir jou wat als in jou map is. Human Objects display nie mooi nie
    System.out.println(basic.keySet());//wys die keys
    System.out.println(basic.values());// wys die values
    
    if(basic.containsKey("three"))
    {
      Human use1 = map.get("three");
      System.out.println(use1.getname() + " Exists"); //stuur 1 terug indien die persoon daar is, null andersins
    }
    else
    {
      System.out.println("bestaan nie in 'Basic' map");
    }

    int totV = 0;
    for(int v : basic.values())
    {
      totV = totV+ v;
    }
    System.out.println("The total value of the basic Map is : "+totV);
    
    System.out.println("\n\n\n\n");
//----------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------- 
    
    
    
    
    
    
    
    
    
    
    
    
    
 //----------------------------------------------------------------------------------   
     //----------------------------------------------------------------------------------
    System.out.println("Using the 'map' HashMap");
    System.out.println("---------------------------");
    
    //maak nuwe humans
    Human p1 = new Human("Jan", "de Wet", 3);
    Human p2 = new Human("sannie", "Pienaar", 20);
    
    //plaas humans in die map
    map.put("Person_1", p1);
    map.put("Person_2", p2);
    
    //kyk net hoe werk die funksies.
    System.out.println(map); //wys vir jou wat als in jou map is. Human Objects display nie mooi nie
    System.out.println(map.keySet());//wys die key 
    System.out.println(map.values());//wys die values
    System.out.println();
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    

    //kyk net of die spesifieke human in die hashmap is.
    if(map.containsKey("Person_1"))
    {
      Human use1 = map.get("Person_1"); // die get metode stuur 'n Human object terug
                                        // hier wil ek maar net die Human klas se mothods kan gebruik.
      
      System.out.println(use1.getname() + " Exists");
    }
    System.out.println();
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    String ja = ""; //skep die variable waarin ek 'n string wil bou
    for(Human names : map.values()) // omdat die map.values() die Values (wat objects van tiepe Human is) in die map aanstuur,
    {                               // stoor ek hulle in 'n names variable van tiepe Human.
      ja = ja + names.getname()+" ";
      //gebruik die Human variable (name) om die Human methods te gebruik, om 'n string te bou, wat al die name bevat
    }
    System.out.println(ja);// print die String
    System.out.println();
    
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    Human use2 = map.get("Person_2"); //map.get() stuur die Human Object terug [amper net soos map.Valuas() in 'n for loop]
    System.out.println(use2.getname() +" "+ use2.getSname()+" is "+ use2.getAge());
    System.out.println(); // een manier hoe om die map values te gebruik
    
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    // Hier is net 'n bewys dat wanneer daar 'n key value geadd word, wat alreeds in die HashMap bestaan,
    // dat dit heeltemal vervang word met die nuwe value.
    // dws die key map(point) nou na 'n nuwe object.
    Human p3 = new Human("koos ", "best", 50);
    map.put("Person_2", p3);
    
    Human use3 = map.get("Person_2");
    System.out.println(use3.getname() +" "+ use3.getSname()+" is "+ use3.getAge());
    //nou sien ons dat dit werklik gebeur het en dat die inskrywing (Sannie Pienaar, 20)
    //nie meer bestaan in die HashMap nie.
    
    
    
   //----------------------------------------------------------------------------------     
//----------------------------------------------------------------------------------
  }
}

