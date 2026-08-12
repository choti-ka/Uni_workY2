import java.util.Scanner;

public class Ncalculator2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //input n
        System.out.print("Enter n : ");
        int n = input.nextInt();
        int sum = 0;

        //calculate sum
        int startNumber    = 1; // startNumber = the start number
        while(startNumber<=n){
            sum += startNumber; // calculate sum from 1 to n
            startNumber++; // startNumber increase
        }
        input.close();

        //output
        System.out.println("Sum = "+sum);
    }
}