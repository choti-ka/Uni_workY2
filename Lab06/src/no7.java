import java.util.*;

public class no7{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        //display
        System.out.println("Original: ");
        System.out.println(numbers);
        //insert q
        System.out.print("Enter index to insert: ");
        int index = input.nextInt();
        if(index<=numbers.size()-1 && index>=0){
            System.out.print("Enter value: ");
            int value = input.nextInt();
            //insert
            numbers.add(index,value);
            //display insert
            System.out.println("After insert: ");
            System.out.println(numbers);
        } else {
            System.out.println("Index not found");
        }
        //del q
        System.out.print("Enter index to delete: ");
        int del = input.nextInt();
        if(del<=numbers.size()-1 && del>=0){
            //del
            numbers.remove(del);
            //display del
            System.out.println("After delete: ");
            System.out.println(numbers);
        } else {
            System.out.println("Index not found");
        }
    }
}
