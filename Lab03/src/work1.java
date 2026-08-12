import java.util.Scanner;

public class work1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //input number
        int[] number = new int[5];
        for(int i=0;i<number.length;i++){
            System.out.print("Input number "+(i+1)+"# ");
            number[i] = input.nextInt();
        }
        //display number
        for(int i=0;i<number.length;i++){
            System.out.println(number[i]);
        }
        input.close();
    }
}
