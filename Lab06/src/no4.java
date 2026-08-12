import java.util.*;

public class no4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> score = new ArrayList<>();
        score.add(55);
        score.add(72);
        score.add(80);
        score.add(65);
        score.add(90);

        System.out.print("Enter score: ");
        int search = input.nextInt();

        boolean found = false;
        for(int i=0;i<score.size();i++){
            if(search==score.get(i)){
                System.out.print("Found at index: "+i);
                found = true;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
}
