import java.util.Scanner;

public class petStatus {

    public void displayPets(String[][] petID, String[] status, Scanner input) {
        boolean running = true;

        while (running) {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│              🐾 ANIMAL SHELTER 🐾                │");
            System.out.println("├──────────────┬──────────┬──────────┬─────────────┤");
            System.out.printf("│ %-12s │ %-8s │ %-8s │ %-11s │%n", "NAME", "SEX", "TYPE", "STATUS");
            System.out.println("├──────────────┼──────────┼──────────┼─────────────┤");

            for (int i = 0; i < petID.length; i++) {
                if(petID[i][0]==null){
                    break;
                }
                System.out.printf("│ %-12s │ %-8s │ %-8s │ %-11s │%n", petID[i][0], petID[i][1], petID[i][2], status[i]);
            }
            System.out.println("└──────────────┴──────────┴──────────┴─────────────┘");
            System.out.print("Who are you interested in? (Type name or 'back' to exit): ");

            String pickPet = input.nextLine().trim();
            // user  go back to the main menu
            if (pickPet.equalsIgnoreCase("back")) {
                running = false;
                break;
            }
            boolean found = false;
            for (int i = 0; i < petID.length; i++) {
                if (petID[i][0].equalsIgnoreCase(pickPet)) {
                    found = true;
                    if (status[i].equalsIgnoreCase("pending") || status[i].equalsIgnoreCase("adopt")) {
                        System.out.println("Status : " + status[i]);
                        System.out.println("Sorry - " + petID[i][0] + " - has already got someone's heart! ❤\n");
                    }
                    else if (status[i].equalsIgnoreCase("available")) {
                        System.out.println("Do you want to adopt - " + petID[i][0] + " - (Y/N)?");
                        String userAnswer = input.nextLine().trim().toLowerCase();

                        if (userAnswer.equals("y") || userAnswer.equals("yes")) {
                            System.out.println("\nThank you for applying! \nWe'll get back to you soon ૮ – ﻌ–a ");
                            status[i] = "pending";
                            System.out.println(petID[i][0] + " status is now: pending...\n");
                        } else {
                            System.out.println("No problem! Take your time looking around.\n");
                        }
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("⚠️ Sorry, we don't have a pet named - " + pickPet + " -");
            }
        }
    }
}