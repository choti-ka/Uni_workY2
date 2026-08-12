import java.util.Scanner;

public class work6 {
    public static void main(String[] args){
            Scanner input = new Scanner(System.in);

            int [] number = {10,20,30,40,50};
            System.out.print("Array: ");
            for(int show:number){
                System.out.print(+show+" ");
            }
            System.out.println();
            System.out.print("Change at index: ");
            int index = input.nextInt();
            //check index range
            if(index>=number.length || index<0){
                System.out.print("Index number " +index+" is out of range");
            } else {
                System.out.print("Change to: ");
                int changeto = input.nextInt();
                int[] ans = change(changeto, index, number);
                System.out.print("Updated Array: ");
                for (int show : ans) {
                    System.out.print(show + " ");
                }
                System.out.println();
            }
        //test -1
        int [] number2 = {10,20,30,40,50};
        System.out.print("Array: ");
        for(int show:number2){
            System.out.print(+show+" ");
        }
        System.out.println();
        int [] ans2 = change(67,-1,number2);
        if(ans2==null){
            System.out.print("Index is out of range");
            System.out.println();
        } else {
            System.out.print("Updated Array: ");
            for(int show:ans2){
                System.out.print(show+" ");
            }
            System.out.println();
        }
        //test 0
        int [] number3 = {10,20,30,40,50};
        System.out.print("Array: ");
        for(int show:number3){
            System.out.print(+show+" ");
        }
        System.out.println();
        int [] ans3 = change(69,0,number3);
        if(ans3==null){
            System.out.print("Index is out of range");
            System.out.println();
        } else {
            System.out.print("Updated Array: ");
            for(int show:ans3){
                System.out.print(show+" ");
            }
            System.out.println();
        }
    }
    public static int[] change(int changeto, int index, int[] number){
        if(index>=number.length || index<0){
            return null;
        }
        number[index] = changeto;
        return number;
    }
}