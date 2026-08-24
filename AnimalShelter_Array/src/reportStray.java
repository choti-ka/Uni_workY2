import java.util.Scanner;

public class reportStray {
    public void creatReport(String[][] strayID, Scanner input){

        //stray type
        System.out.println("1. What type of animal is it? (Cat or Dog)");
        String straytype = input.nextLine();
        if(!straytype.equalsIgnoreCase("Cat") && !straytype.equalsIgnoreCase("Dog")){
            System.out.print("We only accept Cat and Dog at this moment!");
            return;
        }
        //location found at
        System.out.println("2. Where was it found?");
        String strayLocation = input.nextLine();
        if(strayLocation.isEmpty()){
            System.out.println("\uFE0F Location can't be empty!");
            return;
        }
        //stray condition
        System.out.println("3. Animal Conditions? (Healthy / Injured / Sick)");
        String strayCon = input.nextLine().trim();
        if (!strayCon.equalsIgnoreCase("Healthy") &&
                !strayCon.equalsIgnoreCase("Injured") &&
                !strayCon.equalsIgnoreCase("Sick")) {
            System.out.println("\uFE0F Please specify! Healthy, Injured, or Sick.");
            return;
        }
        //save info to strayID
        for (int i=0;i<strayID.length;i++){
            if(strayID[i][0]==null){
                strayID[i][0] = straytype;
                strayID[i][1] = strayLocation;
                strayID[i][2] = strayCon;
            }
        }
        System.out.print("Thank you for reporting! Our rescue team has logged this request.\uD83D\uDC36✨\n\n");
    }
}