import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "student.txt";
        TreeMap<String, String> studentMap = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t", 2);
                if (parts.length == 2) {
                    String studentId = parts[0].trim();
                    String studentName = parts[1].trim();
                    studentMap.put(studentId, studentName);
                }
            }
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
            return;
        }
        Scanner scanner = new Scanner(System.in);

        long[] searchTimes = new long[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("\n#" + (i + 1) + " Enter ID : ");
            String searchId = scanner.nextLine().trim();

            long startTime = System.nanoTime();

            if (studentMap.containsKey(searchId)) {
                System.out.println("Found " + studentMap.get(searchId));
            } else {
                System.out.println("Not Found " + searchId);
            }

            long endTime = System.nanoTime();
            searchTimes[i] = endTime - startTime;
        }

        long totalTime = 0;
        for (long time : searchTimes) {
            totalTime += time;
        }
        double averageTime = (double) totalTime / 10;

        System.out.println("Average Time " + averageTime);

        scanner.close();
    }
}