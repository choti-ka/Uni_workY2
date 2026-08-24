import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        String[][] strayID = new String[10][3];
        String[][] petID = new String[20][3]; //add room for new animal
        String[] status = new String[20];

        String[][] oldPets = {
                {"Monk", "Male", "Dog"}, {"Coconut", "Male", "Dog"}, {"Pumpkin", "Female", "Dog"},
                {"Mayom", "Female", "Cat"}, {"Kiwi", "Female", "Cat"}, {"Cartoon", "Male", "Cat"},
                {"Bell", "Female", "Dog"}
        };
        String[] oldStatus = {"pending", "available", "available", "adopt", "available", "available", "available"};
        // put old in new to show
        for (int i = 0; i < oldPets.length; i++) {
            petID[i] = oldPets[i];
            status[i] = oldStatus[i];
        }
        while(running){
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│              🐾 KITTY SHELTER 🐾                │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.println("│ 1. View Animal Available for Adoption            │");
            System.out.println("│ 2. Report a Stray                                │");
            System.out.println("│ 3. View Report                                   │");
            System.out.println("│ 4. Add a New Animal to Shelter                   │");
            System.out.println("│ 5. Exit System                                   │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("Select an option (1-5): ");
            int userOpt = input.nextInt();
            input.nextLine();

            switch (userOpt){
                case 1:
                    petStatus petManager = new petStatus();
                    petManager.displayPets(petID, status, input);
                    break;

                case 2:
                    reportStray reporter = new reportStray();
                    reporter.creatReport(strayID, input);
                    break;

                case 3:
                    viewReport view = new viewReport();
                    view.displayReport(strayID);
                    break;

                case 4:
                    addNew add = new addNew();
                    add.addAnimal(petID, status, input);
                    break;

                case 5:
                    System.out.println("Thank you for visiting! \uD83D\uDC4B");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        input.close();
    }
}
