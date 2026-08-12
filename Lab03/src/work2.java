import java.util.Scanner;

public class work2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //input number
        System.out.print("Enter number of data : ");
        int datanum = input.nextInt();
        int[] number = new int[datanum];

        for(int i=0;i<number.length;i++){
            System.out.print("Enter data #"+(i+1)+" : ");
            number[i] = input.nextInt();
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i=0;i<number.length;i++){
            if(number[i]>max1){
                max2 = max1;
                max1 = number[i];
            } else if (number[i] > max2 && number[i]<max1) {
                max2 = number[i];
            }

        }
        System.out.println("Max1 = "+max1);
        if(max2!= Integer.MIN_VALUE){
            System.out.println("Max2 = "+max2);
        } else {
            System.out.print("Max2 is not found");
        }
        input.close();
    }
}
