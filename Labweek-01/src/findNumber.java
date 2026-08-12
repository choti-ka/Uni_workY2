import java.util.Scanner;

public class findNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        //input
        System.out.print("Enter 5 numbers : ");
        for (int i=0;i<numbers.length;i++){
            numbers[i]=input.nextInt();
        }

        //search
        System.out.print("Enter number to search : ");
        int search = input.nextInt();

        //find number
        boolean found = false;
        for (int i =0;i<numbers.length;i++){
            if (numbers[i] == search){
                System.out.print("Found at index "+ i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.print("Not Found");
        }
        input.close();
    }
}
