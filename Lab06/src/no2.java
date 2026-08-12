import java.util.*;

public class no2 {
    public static void main(String[] args){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        System.out.println("First fruit: "+fruits.get(0));
        System.out.println("Last fruit: "+fruits.get(3));
        System.out.println("Number of fruits: "+fruits.size());
    }
}
