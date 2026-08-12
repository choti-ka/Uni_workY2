import java.util.*;

public class no9 {
    public static void main(String[] args){
        Scanner inputt = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(78);
        numbers.add(65);
        numbers.add(90);
        numbers.add(55);
        numbers.add(82);
        numbers.add(90);
        numbers.add(70);
        numbers.add(45);
        numbers.add(88);
        numbers.add(60);

        int sum=0;
        double avg=0;
        int count=0; //count above avg
        int max=numbers.get(0);
        int min=numbers.get(0);
        ArrayList<Integer> above = new ArrayList<>(); //above avg

        for(int i=0;i<numbers.size();i++){
            sum += numbers.get(i);
            //max
            if(max<numbers.get(i)){
                max = numbers.get(i);
            }
            //min
            if(min>numbers.get(i)){
                min = numbers.get(i);
            }
        }
        avg = (double) sum/numbers.size();
        for (int i=0;i<numbers.size();i++){
            if(numbers.get(i)>=avg){
                above.add(numbers.get(i));
                count++;
            }
        }

        System.out.println("Data : "+numbers);
        System.out.println("Average = "+avg);
        System.out.println("Max = "+max);
        System.out.println("Min = "+min);
        System.out.println("Number of scores above average : "+count);
        System.out.println("Above average scores : "+above);
    }
}
