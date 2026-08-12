import java.util.Scanner;

public class calculateSquare {
    public static int square(int x){
        return x*x;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //input
        System.out.print("Enter x : ");
        int x = input.nextInt();

        //output
        System.out.print(x+" * "+x+" = "+square(x));
        input.close();
    }
}
