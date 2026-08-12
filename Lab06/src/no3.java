import java.util.*;

public class no3 {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        names.add("Jenny");
        names.add("Peter");
        names.add("Catherine");
        names.add("Jason");

        names.set(1,"Carl");
        names.remove("Catherine");
        System.out.println("Result : ");
        for(int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }
    }
}
