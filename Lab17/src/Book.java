import java.io.*;
import java.util.*;

public class Book {
    public static void main(String[] args) {
        String inputFilePath = "book.txt";
        String outputFilePath = "count.txt";

        Map<String, Integer> wordCountMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // แยกคำk เอาเฉพาะ A-Z a-z
                String[] words = line.split("[^a-zA-Z]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        String lowerCaseWord = word.toLowerCase();
                        wordCountMap.put(lowerCaseWord, wordCountMap.getOrDefault(lowerCaseWord, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
            return;
        }

        // count.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("Result :\n");
            writer.write("--------------------------------\n");

            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            System.out.println("Save to count.txt ");
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
