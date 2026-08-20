import java.util.*;

public class TestPair {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Pair<String, String>[] pair = new Pair[5];
        for(int i=0;i<5;i++){
            System.out.println("#"+(i+1));
            System.out.print("Enter Student ID : ");
            String stuID = input.nextLine();

            System.out.print("Enter name : ");
            String stuName = input.nextLine();

            Pair<String ,String> inPut = new Pair<>(null,null);
            inPut.setKey(stuID);
            inPut.setValue(stuName);

            pair[i] = inPut;
        }
        System.out.println("=======List=======");
        for(int i=0;i<5;i++){
            System.out.println((i+1)+". ");
            System.out.println("Student ID : "+pair[i].getKey());
            System.out.println("Student Name : "+pair[i].getValue());
            System.out.println();
        }
    }
}
