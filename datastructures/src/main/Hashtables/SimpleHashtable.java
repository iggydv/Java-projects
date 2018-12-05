package main.Hashtables;

public class SimpleHashtable {
    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    /**
     * Should be a valid array index
     *
    **/
    private int hashKey(String key) {
        // just making sure we are are hashing between 1 and 10
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee e) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("Sorry, index position is filled: "+ hashedKey);
        } else {
            hashtable[hashedKey] = e;
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }
}
