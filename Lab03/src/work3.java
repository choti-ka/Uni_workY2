import java.util.Scanner;

public class work3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //input number
        System.out.print("Enter number of data : ");
        int datanum = input.nextInt();
        int[] number = new int[datanum];

        for (int i = 0; i < number.length; i++) {
            System.out.print("Enter data #" + (i + 1) + " : ");
            number[i] = input.nextInt();
        }
        System.out.print("Search number : ");
        int search = input.nextInt();
        int ans = searchNumber(number,search);
        System.out.println(ans);
    }
    public static int searchNumber( int[] number, int search) {
        for (int j = 0; j < number.length; j++) {
            if (number[j] == search) {
                return j;
            }
        }
        return -1;
    }
}

