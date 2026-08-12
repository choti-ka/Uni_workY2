import java.util.*;

public class no1 {
    public static void main(String[] args){
        ArrayList<Integer> number = new ArrayList<>();
        number.add(10);
        number.add(20);
        number.add(30);
        number.add(40);
        number.add(50);

        System.out.println("Data in ArrayList:");
        for(int i=0;i<number.size();i++){
            System.out.print(number.get(i)+" ");
        }
    }
}
