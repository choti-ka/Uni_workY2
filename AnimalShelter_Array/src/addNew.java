import java.util.Scanner;

public class addNew {
    public void addAnimal(String[][] petID, String[] status, Scanner input) {
        //new name
        System.out.println("1. What is it name?");
        String name = input.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name can not be empty");
            return;
        }
        //new sex
        System.out.println("2. What sex is it? (Male/Female)");
        String sex = input.nextLine();
        if (!sex.equalsIgnoreCase("Male") && !sex.equalsIgnoreCase("Female")) {
            System.out.println("Please enter Male or Female");
            return;
        }
        //new type
        System.out.println("3. What type? (Cat/Dog)");
        String type = input.nextLine();
        if (!type.equalsIgnoreCase("Cat") && !type.equalsIgnoreCase("Dog")) {
            System.out.println("We only accept Cat and Dog at this moment!");
            return;
        }
        // save info to petID
        boolean added = false;
        for (int i = 0; i < petID.length; i++) {
            if (petID[i][0] == null) {
                petID[i][0] = name;
                petID[i][1] = sex;
                petID[i][2] = type;
                status[i] = "available";
                added = true;
                break;
            }
        }
        if (added) {
            System.out.println(name + " has been added to the shelter!\n");
        } else {
            System.out.println("⚠️ Sorry, the shelter list is full right now.\n");
        }
    }
}

