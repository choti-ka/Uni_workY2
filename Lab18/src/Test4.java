import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        List<Integer> numbers = readNumbersFromFile("number3.txt");
        if (numbers == null) {
            System.out.println("Error");
            return;
        }

        System.out.println("ข้อมูลก่อนเรียงลำดับ:");
        printList(numbers);

        List<Integer> bubbleSortNumbers = new ArrayList<>(numbers);
        List<Integer> selectionSortNumbers = new ArrayList<>(numbers);
        List<Integer> insertionSortNumbers = new ArrayList<>(numbers);
        List<Integer> mergeSortNumbers = new ArrayList<>(numbers);

        long startTime = System.nanoTime();
        bubbleSort(bubbleSortNumbers);
        long endTime = System.nanoTime();
        double bubbleSortTime = (endTime - startTime) / 1_000_000.0; // แปลงเป็นมิลลิวินาที

        startTime = System.nanoTime();
        selectionSort(selectionSortNumbers);
        endTime = System.nanoTime();
        double selectionSortTime = (endTime - startTime) / 1_000_000.0;

        startTime = System.nanoTime();
        insertionSort(insertionSortNumbers);
        endTime = System.nanoTime();
        double insertionSortTime = (endTime - startTime) / 1_000_000.0;

        startTime = System.nanoTime();
        mergeSort(mergeSortNumbers, 0, mergeSortNumbers.size() - 1);
        endTime = System.nanoTime();
        double mergeSortTime = (endTime - startTime) / 1_000_000.0;

        // แสดงผลลัพธ์หลังเรียงลำดับ
        System.out.println("\nข้อมูลหลังเรียงลำดับด้วย Bubble Sort:");
        printList(bubbleSortNumbers);

        System.out.println("\nข้อมูลหลังเรียงลำดับด้วย Selection Sort:");
        printList(selectionSortNumbers);

        System.out.println("\nข้อมูลหลังเรียงลำดับด้วย Insertion Sort:");
        printList(insertionSortNumbers);

        System.out.println("\nข้อมูลหลังเรียงลำดับด้วย Merge Sort:");
        printList(mergeSortNumbers);

        System.out.println("\nAverage Time :");
        System.out.println("Bubble Sort: "+bubbleSortTime);
        System.out.println("Selection Sort: "+selectionSortTime);
        System.out.println("Insertion Sort: "+insertionSortTime);
        System.out.println("Merge Sort: " + mergeSortTime);
    }

    public static List<Integer> readNumbersFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    for (String part : parts) {
                        try {
                            numbers.add(Integer.parseInt(part));
                        } catch (NumberFormatException e) {
                            System.err.println("ข้อมูลไม่ถูกต้อง: " + part);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
            return null;
        }
        return numbers;
    }
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // Bubble Sort
    public static void bubbleSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) { minIndex = j;
                }
            }
            int temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }

    // Insertion Sort
    public static void insertionSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) { arr.set(j + 1, arr.get(j)); j = j - 1;
            } arr.set(j + 1, key);
        }
    }

    // Merge Sort
    public static void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(List<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> L = new ArrayList<>(n1);
        List<Integer> R = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i)
            L.add(arr.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(mid + 1 + j));

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {arr.set(k, L.get(i)); i++;
            } else {arr.set(k, R.get(j)); j++;
            } k++;
        }
        //left
        while (i < n1) {arr.set(k, L.get(i)); i++; k++;
        }
        //right
        while (j < n2) { arr.set(k, R.get(j)); j++; k++;
        }
    }
}
