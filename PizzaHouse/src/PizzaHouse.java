import java.util.*;

class PizzaNode {
    String name;
    double price;
    List<PizzaNode> children; //สร้างตนไม้

    public PizzaNode(String name, double price) {
        this.name = name;
        this.price = price;
        this.children = new ArrayList<>(); //เก้บลูก
    }
    public void addChild(PizzaNode child) {
        this.children.add(child);
    }
}
public class PizzaHouse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("=           Pizza House           =");
        System.out.println("===================================");
        System.out.println("1.Hawaiian Pizza\t\t($159.00)");
        System.out.println("2.Peperoni Pizza\t\t($159.00)");
        System.out.println("3.Double Meat Pizza\t\t($159.00)");
        System.out.println("4.Custom Pizza\t\t\t($139.00)");
        System.out.println("-----------------------------------");
        System.out.println("\t\tEnter '5' to exit!");
        System.out.println("===================================");
        System.out.print("Enter Choice (1-5): ");
        int userOpt = input.nextInt();

        PizzaNode myPizza; //menu -> size -> crust -> topping -> addon no topping or anything najaa
        switch (userOpt){
            case 1: myPizza = new PizzaNode("Hawaiian Pizza", 159.00); break;
            case 2: myPizza = new PizzaNode("Peperoni Pizza", 159.00); break;
            case 3: myPizza = new PizzaNode("Double Meat Pizza", 159.00); break;
            case 4: myPizza = new PizzaNode("Custom Pizza", 139.00); break;
            case 5: System.out.println("Thank you for visiting!"); return;
            default: System.out.println("Invalid Choice!"); return;
        }
        //size option
        PizzaNode sizeCat = new PizzaNode("Size Option", 0.00);
        myPizza.addChild(sizeCat);
        System.out.println("\n=========== Select size ===========");
        System.out.println("1.Small                      ($0.00)");
        System.out.println("2.Medium                   (+$79.00)");
        System.out.println("3.Large                   (+$199.00)");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice (1-3) : ");
        int userSize = input.nextInt();

        switch (userSize){
            case 1: sizeCat.addChild(new PizzaNode("Small Size", 0.00)); break;
            case 2: sizeCat.addChild(new PizzaNode("Medium Size", 79.00)); break;
            case 3: sizeCat.addChild(new PizzaNode("Large Size", 199.00)); break;
            default: System.out.println("Invalid Choice!"); break;
        }
        //crust option
        PizzaNode crustCat = new PizzaNode("Crust Option", 0.00);
        myPizza.addChild(crustCat);
        System.out.println("\n=========== Select crust ===========");
        System.out.println("1.Thick                      ($0.00)");
        System.out.println("2.Thin                       ($0.00)");
        System.out.println("3.Cheese Stuffed           (+$68.00)");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice (1-3) : ");
        int userCrust = input.nextInt();

        switch (userCrust){
            case 1: crustCat.addChild(new PizzaNode("Thick Crust", 0.00)); break;
            case 2: crustCat.addChild(new PizzaNode("Thin Crust", 0.00)); break;
            case 3: crustCat.addChild(new PizzaNode("Cheese Stuffed Crust", 68.00)); break;
            default: System.out.println("Invalid Choice!"); break;
        }

        //topping option
        PizzaNode toppingsCat = new PizzaNode("Toppings", 0.00);
        myPizza.addChild(toppingsCat);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\n=========== Add Toppings ===========");
            System.out.println("1. Pepperoni                (+$59.00)");
            System.out.println("2. Extra Cheese             (+$79.00)");
            System.out.println("3. Mushrooms                (+$49.00)");
            System.out.println("4. Bacon                    (+$59.00)");
            System.out.println("5. Shrimp                   (+$79.00)");
            System.out.println("6. Tomato                   (+$49.00)");
            System.out.println("-------------------------------------");
            System.out.println("Done adding toppings? Enter '7' to Exit!");
            System.out.print("Enter choice (1-7) : ");
            int userTop = input.nextInt();

            switch (userTop) {
                case 1: toppingsCat.addChild(new PizzaNode("Pepperoni", 59.00)); System.out.println("-> Added Pepperoni!"); break;
                case 2: toppingsCat.addChild(new PizzaNode("Extra Cheese", 79.00)); System.out.println("-> Added Extra Cheese!"); break;
                case 3: toppingsCat.addChild(new PizzaNode("Mushrooms", 49.00)); System.out.println("-> Added Mushrooms!"); break;
                case 4: toppingsCat.addChild(new PizzaNode("Bacon", 59.00)); System.out.println("-> Added Bacon!"); break;
                case 5: toppingsCat.addChild(new PizzaNode("Shrimp", 79.00)); System.out.println("-> Added Shrimp!"); break;
                case 6: toppingsCat.addChild(new PizzaNode("Tomato", 49.00)); System.out.println("-> Added Tomato!"); break;
                case 7: addingToppings = false; break;
                default: System.out.println("Invalid Choice!"); break;
            }
        }
        //addon option
        PizzaNode addon = new PizzaNode("Adds-on", 0.00);
        myPizza.addChild(addon);

        boolean addingAddon = true;
        while (addingAddon){
            System.out.println("\n=========== Adds-on ===========");
            System.out.println("1.Mash Potato              ($49.00)");
            System.out.println("2.Chicken Wings(x5)       ($119.00)");
            System.out.println("3.Bread Stick(x2)          (+$57.00)");
            System.out.println("4.Garlic Bread(x2)         (+$57.00)");
            System.out.println("5.Cheese Sick(x2)          (+$69.00)");
            System.out.println("6.Spaghetti Carbonara      (+$75.00)");
            System.out.println("-----------------------------------");
            System.out.println("Done adding adds-on? Enter '7' to Exit!");
            System.out.print("Enter Choice (1-7) : ");
            int userAddon = input.nextInt();

            switch (userAddon){
                case 1: addon.addChild(new PizzaNode("Mash Potato", 49.00)); System.out.println("-> Added Mash Potato!"); break;
                case 2: addon.addChild(new PizzaNode("Chicken Wings(x5)", 119.00)); System.out.println("-> Added Chicken Wings(x5)!"); break;
                case 3: addon.addChild(new PizzaNode("Bread Stick(x2)", 57.00)); System.out.println("-> Added Bread Stick(x2)"); break;
                case 4: addon.addChild(new PizzaNode("Garlic Bread(x2)", 57.00)); System.out.println("-> Added Garlic Bread(x2)!"); break;
                case 5: addon.addChild(new PizzaNode("Cheese Sick(x2)", 69.00)); System.out.println("-> Added Cheese Sick(x2)!"); break;
                case 6: addon.addChild(new PizzaNode("Spaghetti Carbonara", 75.00)); System.out.println("-> Added Spaghetti Carbonara!"); break;
                case 7: addingAddon = false; break;
                default: System.out.println("Invalid Choice!"); break;
            }
        }
        //coupon
        System.out.println("\n------------------------------------");
        ArrayList<String> couponCode = new ArrayList<>();
        couponCode.add("PIZZAHOUSE");
        couponCode.add("NEWOPEN2026");
        boolean coupon = false;
        boolean addcoupon = true;
        System.out.print("\nDo you have coupons? (Y/N) : ");
        String userCoupon = input.next();
        while (addcoupon) {
            if (userCoupon.equalsIgnoreCase("Y")){
                System.out.print("\nEnter Coupon Code : ");
                String userCode = input.next();
                for (int i=0;i < couponCode.size();i++){
                    if (userCode.equalsIgnoreCase(couponCode.get(i))){
                        System.out.println("-> Coupon applied! (10% OFF)");
                        coupon = true;
                        addcoupon = false;
                        break;
                    } else if (userCode.equalsIgnoreCase("cancel")){
                        addcoupon = false;
                        break;
                    } else {
                        System.out.println("\nInvalid Coupon! Please Try Again.");
                        System.out.println("Type 'cancel' to go foward if you dont have coupon");
                        break;
                    }
                }

            } else {
                addcoupon = false;
                break;
            }
        }

        // reciept
        System.out.println("\n====================================");
        System.out.println("                Receipt              ");
        System.out.println("====================================");
        printTree(myPizza, "");
        double total = calculateTotal(myPizza);
        if (coupon){
            double discount = total * 0.10;
            discount = Math.round(discount * 100.0) / 100.0;
            total -= discount;
            System.out.println("Discount (10%): -" + discount);
        }
        System.out.println("------------------------------------");
        System.out.println("TOTAL AMOUNT : $" + total);
        System.out.println("------------------------------------");

        input.close();
    }
    //show recipet
    public static void printTree(PizzaNode myPizza, String indent) {
        if (myPizza.price > 0) {
            System.out.printf("%s- %s ($%.2f)%n", indent, myPizza.name, myPizza.price);
        } else {
            System.out.printf("%s- %s%n", indent, myPizza.name);
        }

        for (PizzaNode child : myPizza.children) {
            printTree(child, indent + "   ");
        }
    }
    //calculate price
    public static double calculateTotal(PizzaNode myPizza) {
        double sum = myPizza.price;
        for (PizzaNode child : myPizza.children) {
            sum += calculateTotal(child);
        }
        return sum;
    }
}
