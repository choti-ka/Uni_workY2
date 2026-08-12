import java.util.*;

public class work10 {
    static int[] numbers = new int[10];
    static int count = 0;

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        
        while(running) {
            System.out.println("===== ARRAY MENU =====");
            System.out.println("1. Add Data");
            System.out.println("2. Display Data");
            System.out.println("3. Search Data");
            System.out.println("4. Insert Data by Index");
            System.out.println("5. Delete Data by Index");
            System.out.println("6. Delete Data by dataValue");
            System.out.println("7. Exit");
            System.out.println("=====================");

            System.out.print("Enter choice : ");
            int opt = input.nextInt();

            switch (opt) {
                case 1:
                    addData(input);
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    searchData(input);
                    break;
                case 4:
                    insertByIndex(input);
                    break;
                case 5:
                    delByIndex(input);
                    break;
                case 6:
                    delByValue(input);
                    break;
                case 7:
                    System.out.print("Exit System");
                    running = false;
                    break;
                default:
                    System.out.println("Enter 1-7 only");
                    break;
            }
        }
    }
    //add data into array
    public static void addData(Scanner input){
        if(count>= numbers.length){
            System.out.println("Array is full!");
            return;
        }
        System.out.print("Enter data number : ");
        int datanum = input.nextInt();
        for(int i=0;i<datanum;i++){
            System.out.print("Enter data #"+(i+1)+" : ");
            int data = input.nextInt();
            numbers[count]=data;
            count++;
        }
        System.out.println();
    }
    //display array
    public static void displayData(){
        if(count==0){
            System.out.println("No data in array");
            return;
        }
        System.out.print("Array : ");
        for(int i=0;i<count;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    //search data
    public static void searchData(Scanner input){
        int tempIndex = -1;
        boolean found = false;
        if(count==0){
            System.out.println("No data in array to search yet");
            return;
        }
        System.out.print("Search : ");
        int search = input.nextInt();
        for (int i=0;i<count;i++){
            if(search==numbers[i]){
                found = true;
                tempIndex = i;
            }
        }
        if(found){
            System.out.println("Found "+search+" in array at "+tempIndex);
        } else {
            System.out.println("Can't find "+search+" in array");
            return;
        }
    }
    //insert data
    public static void insertByIndex(Scanner input){
        if (count >= numbers.length ) {
            System.out.println("Can't insert data");
            return;
        }
        System.out.print("Inset at index : ");
        int insertIndex = input.nextInt();
        if(insertIndex < 0 || insertIndex > count) {
            System.out.println("Invalid index!");
            return;
        }
        System.out.print("Insert data : ");
        int insertData = input.nextInt();
        for (int i = count; i > insertIndex; i--) {
            numbers[i] = numbers[i - 1];
        }
        numbers[insertIndex] = insertData;
        count++;
    }
    //del by index
    public static void delByIndex(Scanner input){
        if (count==0) {
            System.out.println("Can't delete data");
            return;
        }
        System.out.print("Delete at index : ");
        int deleteIndex = input.nextInt();
        if(deleteIndex < 0 || deleteIndex >= count) {
            System.out.println("Invalid index!");
            return;
        }
        for (int i = deleteIndex; i < count - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        count--;
    }
    //del by value
    public static void delByValue(Scanner input){
        int tempIndex = -1;
        if (count==0) {
            System.out.println("Can't delete data");
            return;
        }
        System.out.print("Delete at value : ");
        int deleteValue = input.nextInt();
        for (int i=0;i<count;i++){
            if(deleteValue==numbers[i]){
                tempIndex = i;
                break;
            }
        }
        if(tempIndex != -1){
            for (int i = tempIndex; i < count - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            count--;
            System.out.println("Deleted " + deleteValue + " successfully!");
        } else {
            System.out.println("Can't find " + deleteValue + " in array");
        }
    }

}
