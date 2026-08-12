import java.util.*;

public class number2 {
    static class Task {
        String name;
        Task(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Sort task(Alphabet)");
            System.out.println("4. Show all tasks");
            System.out.println("5. Exit");
            System.out.println("------------");
            System.out.print("Choose : ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("------------");
                    System.out.print("Enter task : ");
                    String name = scanner.nextLine();
                    tasks.add(new Task(name));
                    break;

                case 2:
                    System.out.println("------------");
                    System.out.print("Enter task to delete: ");
                    String del = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < tasks.size(); i++) {
                        if (Objects.equals(del, tasks.get(i).name)) {
                            tasks.remove(i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Task not found");
                    }
                    break;

                case 3:
                    System.out.println("------------");
                    tasks.sort(Comparator.comparing(t -> t.name.toLowerCase()));
                    System.out.println("To-Do-List(Alphabet):");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).name);
                    }
                    System.out.println("============");
                    break;

                case 4:
                    System.out.println("\n============");
                    System.out.println("To-Do-List:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).name);
                    }
                    System.out.println("============");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}



