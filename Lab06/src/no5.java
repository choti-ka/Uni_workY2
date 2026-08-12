import java.util.*;

public class no5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(75);
        numbers.add(80);
        numbers.add(65);
        numbers.add(90);
        numbers.add(85);
        numbers.add(70);

        int sum = 0;
        double avg = 0;
        int max = numbers.get(0);
        int min = numbers.get(0);
        for(int i=0;i<numbers.size();i++){
            sum += numbers.get(i);
            if(numbers.get(i)>max){
                max = numbers.get(i);
            }
            if(min>numbers.get(i)){
                min = numbers.get(i);
            }
        }
        avg = (double) sum/numbers.size();
        System.out.println("Sum = "+sum);
        System.out.println("Average = "+avg);
        System.out.println("Maximum = "+max);
        System.out.println("Minimum = "+min);
    }
}
