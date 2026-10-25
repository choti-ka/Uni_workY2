import java.util.*;

public class CoffeeMenu {
    //menu class
    static class Menu {
        String name;
        String type;
        int price;
        public Menu(String name, String type, int price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }
        @Override
        public String toString() {
            return name + " (" + type + ") - $" + price;
        }
    }
    // cusorder
    static class Order {
        int queueNumber;
        String cusName;
        String menuName;
        String drinkType;
        int amount;
        int totalPrice;
        String status;
        public Order(int queueNumber, String cusName, String menuName, String drinkType, int amount, int totalPrice) {
            this.queueNumber = queueNumber;
            this.cusName = cusName;
            this.menuName = menuName;
            this.drinkType = drinkType;
            this.amount = amount;
            this.totalPrice = totalPrice;
            this.status = "in progress";
        }
        @Override
        public String toString() {
            return "#" + queueNumber + " | Khun " + cusName + " | " + menuName + " (" + drinkType + ") x" + amount +
                    " | Total: $" + totalPrice + " | Status: " + status;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Menu> drinks = new ArrayList<>();
        List<Order> allOrders = new ArrayList<>(); // all order
        Queue<Order> processingQueue = new LinkedList<>(); // current order
        int queueCounter = 1;
        // menu
        drinks.add(new Menu("Americano", "Hot/Ice", 50));
        drinks.add(new Menu("Latte", "Hot/Ice", 60));
        drinks.add(new Menu("Espresso", "Hot", 50));
        drinks.add(new Menu("Matcha Latte", "Ice", 60));
        drinks.add(new Menu("Cocoa", "Hot/Ice", 50));
        drinks.add(new Menu("Thai Tea", "Ice", 50));
        drinks.add(new Menu("Black Tea", "Hot/Ice", 50));
        int userOpt = 0;
        do {
            System.out.println("\n=======+ Coffee Shop +=======");
            System.out.println("1. Place Order ");
            System.out.println("2. Announce Order");
            System.out.println("3. Display All Queue");
            System.out.println("4. Search Order Status");
            System.out.println("5. Exit ");
            System.out.println("=======+=======+=======+=======");
            System.out.print("Choice (1-5): ");
            if (!input.hasNextInt()) {
                System.out.println("Please Enter only 1-5!");
                input.next();
                continue;
            }
            userOpt = input.nextInt();
            input.nextLine();
            switch (userOpt) {
                case 1: // Place Order
                    System.out.println("\n=======+ Menu +=======");
                    for (int i = 0; i < drinks.size(); i++) {
                        System.out.println((i + 1) + ". " + drinks.get(i));
                    }
                    System.out.println("=======+=======+=======+=======");
                    System.out.print("Enter Customer name: ");
                    String cusName = input.nextLine();
                    System.out.print("Enter Drink Number (1-" + drinks.size() + "): ");
                    int menuIndex = input.nextInt() - 1;
                    input.nextLine();
                    if (menuIndex < 0 || menuIndex >= drinks.size()) {
                        System.out.println("Invalid Number!");
                        break;
                    }
                    Menu selectedMenu = drinks.get(menuIndex);
                    System.out.print("Enter Type (Hot/Ice): ");
                    String cusType = input.nextLine();
                    System.out.print("Enter Amount: ");
                    int cusAmount = input.nextInt();
                    input.nextLine();
                    // total if ice +5
                    int basePrice = selectedMenu.price;
                    if (cusType.equalsIgnoreCase("Ice")) {
                        basePrice += 5;
                    }
                    int totalPrice = basePrice * cusAmount;
                    Order newOrder = new Order(queueCounter, cusName, selectedMenu.name, cusType, cusAmount, totalPrice);
                    allOrders.add(newOrder);
                    processingQueue.add(newOrder);
                    // receipt
                    System.out.println("\n=======+ Receipt +=======");
                    System.out.println("Queue Number #" + queueCounter);
                    System.out.println("Khun: " + cusName);
                    System.out.println("List: " + selectedMenu.name + " (" + cusType + ") x" + cusAmount);
                    System.out.println("=======+=======+=======+=======");
                    System.out.println("Total: $" + totalPrice);
                    System.out.println("=======+=======+=======+=======");
                    queueCounter++;
                    break;
                case 2: // announce order
                    if (processingQueue.isEmpty()) {
                        System.out.println("No Queue In Progress At The Moment");
                    } else {
                        Order currentOrder = processingQueue.poll(); //first queue
                        currentOrder.status = "Done";
                        System.out.println("\n Queue Announce");
                        System.out.println("#" + currentOrder.queueNumber + " Khun " + currentOrder.cusName + ", your order are ready!");
                    }
                    break;
                case 3: // display all queue
                    if (allOrders.isEmpty()) {
                        System.out.println("No Queue In Log");
                    } else {
                        System.out.println("\n=======+ All Queue +=======");
                        for (Order order : allOrders) {
                            System.out.println(order);
                        }
                    }
                    break;
                case 4: // search order
                    System.out.print("Enter Queue Number: ");
                    int searchQueue = input.nextInt();
                    input.nextLine();
                    boolean found = false;
                    for (Order order : allOrders) {
                        if (order.queueNumber == searchQueue) {
                            System.out.println("\n=======+ Queue Info +=======");
                            System.out.println(order);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Queue Info #" + searchQueue + "Not Found!");
                    }
                    break;
                case 5: //exit
                    System.out.println("Thank You For Visiting Coffee Shop!");
                    break;
                default:
                    System.out.println("Enter number only 1-5!");
            }
        } while (userOpt != 5);
        input.close();
    }
}