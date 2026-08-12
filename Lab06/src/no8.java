import java.lang.reflect.Array;
import java.util.*;

public class no8{
    public static void main(String[] args){
        ArrayList<String> productList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int opt;
        do{
            System.out.println("===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Product");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.println("========================");
            System.out.print("Choice : ");
            opt = input.nextInt();
            input.nextLine();

            switch (opt){
                //add
                case 1:
                    System.out.println("------------");
                    System.out.print("Add Product: ");
                    String product = input.nextLine();
                    productList.add(product);
                    System.out.println();
                    break;
                //display
                case 2:
                    System.out.println("------------");
                    System.out.println("Display Product: ");
                    for(int i=0;i<productList.size();i++){
                        System.out.println((i+1)+". "+productList.get(i));
                    }
                    System.out.println();
                    break;
                //search
                case 3:
                    boolean found = false;
                    System.out.println("------------");
                    System.out.print("Search Product: ");
                    String search = input.nextLine();
                    for (String s : productList) {
                        if (search.equalsIgnoreCase(s)) {
                            System.out.println("Product found in list");
                            found = true;
                            break;
                        }
                    } if(!found){
                    System.out.println("Product not found");
                }
                    break;
                //update
                case 4:
                    boolean found1 = false;
                    System.out.println("------------");
                    System.out.print("Update Product From: ");
                    String updateF = input.nextLine();
                    int tempindex = 0;
                    for(int i=0;i<productList.size();i++){
                        if(updateF.equalsIgnoreCase(productList.get(i))){
                            tempindex = i;
                            System.out.print("Update Product To: ");
                            String updateT = input.nextLine();
                            productList.set(tempindex,updateT);
                            found1 = true;
                            break;
                        }
                    }
                    if(!found1){
                        System.out.println("Product not found");
                    }
                    break;
                //del
                case 5:
                    boolean found2 = false;
                    System.out.println("------------");
                    System.out.print("Delete Product: ");
                    String del = input.nextLine();
                    int tempindex1;
                    for(int i=0;i<productList.size();i++){
                        if(del.equalsIgnoreCase(productList.get(i))){
                            tempindex1 = i;
                            productList.remove(tempindex1);
                            found2 = true;
                            break;
                        }
                    }
                    if(!found2){
                        System.out.println("Product not found");
                    }
                    break;
                //exit
                case 6:
                    System.out.print("Exit System");
            }

        } while(opt!=6);
        input.close();
    }
}
