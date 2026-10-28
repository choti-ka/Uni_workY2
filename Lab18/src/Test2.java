public class Test2 {
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("ก่อนเรียงลำดับ:");
        printArray(numbers);

        selectionSortWithSteps(numbers);

        System.out.println("\nหลังเรียงลำดับจากน้อยไปมาก:");
        printArray(numbers);
    }

    public static void selectionSortWithSteps(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Round " + (i + 1) + ":");

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.println(arr[minIndex] + " (Min at index " + minIndex + ")");
            printArrayWithHighlight(arr, i, minIndex);

            if (minIndex != i) {
                System.out.print( arr[i] + " ( Index " + i + ") and " + arr[minIndex] + " (Index " + minIndex + "): ");
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                printArrayWithHighlight(arr, i, minIndex);
            } else {
                System.out.println("No Swap");
            }

            System.out.println("Round " + (i + 1) + ":");
            printArray(arr);
            System.out.println();
        }
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void printArrayWithHighlight(int[] arr, int currentPos, int minIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (i == currentPos) {
                System.out.print("[" + arr[i] + "] ");
            } else if (i == minIndex) {
                System.out.print("(" + arr[i] + ") ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
