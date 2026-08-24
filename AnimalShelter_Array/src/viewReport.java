import java.util.Scanner;

public class viewReport {
    public void displayReport (String[][] strayID){
        boolean hasReports = false;

        System.out.println("\n========== 🐾 LOGGED STRAY REPORTS 🐾 ===========");
        System.out.println("┌──────────┬─────────────────────────┬───────────┐");
        System.out.printf("│ %-8s │ %-23s │ %-9s │%n", "TYPE", "LOCATION", "CONDITION");
        System.out.println("├──────────┼─────────────────────────┼───────────┤");
        //display
        for (int i = 0; i < strayID.length; i++) {
            if (strayID[i][0] != null) {
                hasReports = true;
                System.out.printf("│ %-8s │ %-23s │ %-9s │%n",
                        strayID[i][0],
                        strayID[i][1],
                        strayID[i][2]);
            }
        }
        System.out.println("└──────────┴─────────────────────────┴───────────┘");
        System.out.println("=================================================");
        //if have no report
        if (!hasReports) {
            System.out.println("\uFE0F No stray animal reports logged yet.\n");
            return;
        }
    }
}
