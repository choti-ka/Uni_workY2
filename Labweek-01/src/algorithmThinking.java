import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class algorithmThinking {
    public static void sortArray(int[] number){
        //temp storage
        int temp;
        //sorting
        for(int i=number.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(number[j]>number[j+1]){
                    temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] number = new int[5];

        //input
        System.out.print("Enter 5 numbers : ");
        for(int i=0;i<number.length;i++){
            number[i] = input.nextInt();
        }
        sortArray(number);
        //output
        System.out.print(Arrays.toString(number));

        input.close();
    }
}
