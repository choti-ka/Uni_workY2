import java.util.Scanner;

public class work5 {
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
        System.out.print("Search for number: ");
        int search = input.nextInt();
        int[] ans = searchAll(number, search);

        if(ans!=null){
            System.out.print("Found at :");
            for(int index : ans){
                System.out.print(index+" ");
            }
            System.out.println();
        } else {
            System.out.print("Null");
        }

    }
    public static int[] searchAll(int[] number,int search) {
        int count = 0;

        for (int i = 0; i < number.length; i++) {
            if (number[i] == search) {
                count++;
            }
        }
        if(count==0){
            return null;
        }
        int[] ansindex = new int[count];
        int ans = 0;
        for(int j=0;j< number.length;j++){
            if(number[j] == search){
                ansindex[ans++] = j;
            }
        }
        return ansindex;
    }
}