import java.util.*;

public class main {
    static class ID {
        int amount;
        String sex;
        String type;
        int price;
        ID(int amount, String sex, String type, int price) {
            this.amount = amount;
            this.sex = sex;
            this.type = type;
            this.price = price;
        }
        @Override
        public String toString() { //for display
            return "Amount: " + amount + " | Sex: " + sex + " | Type: " + type + " | Price: $" + price;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ID> fih = new ArrayList<>();
        fih.add(new ID(10, "Female", "Gold Fish", 35));
        fih.add(new ID(24, "Mix", "Guppy", 20));
        fih.add(new ID(5, "Male", "Betta Fish", 50));
        fih.add(new ID(6, "Mix", "Koi Fish", 250));
        fih.add(new ID(14, "Mix", "Balloon Fish", 15));
        int userOpt;
        do {
            System.out.println("\n┌──────────────────────────────────────────────────┐");
            System.out.println("│                  FISH  SHOP                      │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.println("│ 1. View Fish Available                           │");
            System.out.println("│ 2. Add Fish                                      │");
            System.out.println("│ 3. Buy Fish                                      │");
            System.out.println("│ 4. Sort By Price                                 │");
            System.out.println("│ 5. Sort By Type                                  │");
            System.out.println("│ 6. Exit System                                   │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("Choice : ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.next();
            }
            userOpt = input.nextInt();
            input.nextLine();
            switch (userOpt) {
                case 1:
                    //display list
                    System.out.println("======== List ========");
                    boolean anyInStock = false;
                    for(ID id : fih){
                        if(id.amount>0){ //if fih was not sold out then display
                            System.out.println(id);
                            anyInStock = true;
                        }
                    }
                    if(!anyInStock){
                        System.out.println("No fish currently in stock");
                    }
                    System.out.println("=======================");
                    break;
                case 2: {
                    //add fih
                    System.out.println("======== Add Fish ========");
                    System.out.print("Fish Amount (limited up to 20): ");
                    int addAmount = input.nextInt();
                    input.nextLine();
                    if (addAmount < 0 || addAmount > 20) {
                        System.out.println("Invalid amount. Cancelling.");
                        break;
                    }
                    System.out.print("Fish Sex : ");
                    String addSex = input.nextLine();
                    if (!addSex.equalsIgnoreCase("male") && !addSex.equalsIgnoreCase("female")
                            && !addSex.equalsIgnoreCase("mix")) {
                        System.out.println("Invalid sex. Cancelling.");
                        break;
                    }
                    System.out.print("Fish Type : ");
                    String addType = input.nextLine();
                    System.out.print("Fish price : ");
                    int addPrice = input.nextInt();
                    input.nextLine();
                    if (addPrice < 0) {
                        System.out.println("Invalid price. Cancelling.");
                        break;
                    }
                    fih.add(new ID(addAmount, addSex, addType, addPrice));
                    System.out.println("Fish added!");
                    System.out.println("=======================");
                    break;
                }
                case 3: {
                    //buy fih
                    System.out.println("======== Buy ========");
                    System.out.print("Enter type : ");
                    String userType = input.nextLine();

                    ID selected = null;
                    for (ID fish : fih) {
                        if (fish.type.equalsIgnoreCase(userType)) {
                            selected = fish;
                            break;
                        }
                    }
                    if (selected != null) {
                        System.out.print("Enter amount : ");
                        int userAmount = input.nextInt();
                        input.nextLine();
                        if (userAmount <= selected.amount) {
                            int totalCost = userAmount * selected.price;
                            System.out.println("You bought " + userAmount + " x " +"$"+ selected.price + " for $" + totalCost);
                            selected.amount -= userAmount;
                        } else {
                            System.out.println("Not enough stock. Only " + selected.amount + " available.");
                        }
                    } else {
                        System.out.println("Invalid choice — fish type not found.");
                    }
                    break;
                }
                case 4:
                    //sort price
                    System.out.println("======== List(Price) ========");
                    fih.sort(Comparator.comparingInt(t -> t.price));
                    for (int i = 0; i < fih.size(); i++) {
                        ID t = fih.get(i);
                        if(fih.get(i).amount>0) {
                            System.out.println((i + 1) + ". " + "$" + t.price + " | Type: " + t.type + " | Amount: " + fih.get(i).amount);
                        }
                    }
                    System.out.println("====================");
                    break;
                case 5:
                    //sort alpha
                    System.out.println("======== List(Alphabet) ========");
                    fih.sort(Comparator.comparing(t -> t.type.toLowerCase()));
                    for (int i = 0; i < fih.size(); i++) {
                        if(fih.get(i).amount>0){
                            System.out.println((i + 1) + ". "+ fih.get(i).type +" | Amount: " + fih.get(i).amount +" | Price: $" +fih.get(i).price);
                        }
                    }
                    System.out.println("====================");
                    break;
                case 6:
                    //exit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (userOpt != 6);
        input.close();
    }
}