import java.util.Scanner;

public class arrayNumber {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];
        int sum = 0;

        //input
        System.out.print("Enter 10 numbers : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }
        //calculate
        int max = numbers[0];
        int min = numbers[0];
        for (int i=0; i< numbers.length; i++){
            if (numbers[i]>max){
                max = numbers[i];
            }
            if (numbers[i]<min){
                min = numbers[i];
            }
        }
        //average
        double avg = (double) sum/ numbers.length;
        //output
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Average = " + avg);

        input.close();
    }
}
