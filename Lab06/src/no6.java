import java.util.*;

public class no6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(45);
        scores.add(67);
        scores.add(82);
        scores.add(55);
        scores.add(91);
        scores.add(73);
        scores.add(38);
        scores.add(88);
        //array for pass and fail
        ArrayList<Integer> passes = new ArrayList<>();
        ArrayList<Integer> fails = new ArrayList<>();
        int pass = 0;
        int fail = 0;
        //find score that pass or fail
        for (int i=0;i<scores.size();i++){
            if(scores.get(i)>= 50){
                pass++;
                passes.add(scores.get(i));
            } else {
                fail++;
                fails.add(scores.get(i));
            }
        }
        //display
        System.out.println("Passed: ");
        for(int show:passes){
            System.out.print(show+" ");
        }
        System.out.println();
        System.out.println("Number of passed: "+pass);
        System.out.println("Failed: ");
        for(int show:fails){
            System.out.print(show+" ");
        }
        System.out.println();
        System.out.println("Number of failed: "+fail);
    }
}
