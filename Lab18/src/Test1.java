public class Test1 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};

        System.out.println("ก่อนเรียงลำดับ:");
        printArray(numbers);

        bubbleSortWithSteps(numbers);

        System.out.println("หลังเรียงลำดับจากน้อยไปมาก:");
        printArray(numbers);
    }

    public static void bubbleSortWithSteps(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("Round " + (i + 1) + ":");

            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print( + j + " (" + arr[j] + ") กับ " + (j + 1) + " (" + arr[j + 1] + ")");

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                    System.out.println(" -> Swap ");
                    printArrayWithHighlight(arr, j, j + 1);
                } else {
                    System.out.println(" -> No Swap");
                }
            }

            if (!swapped) {
                System.out.println("Done");
                break;
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

    public static void printArrayWithHighlight(int[] arr, int index1, int index2) {
        for (int i = 0; i < arr.length; i++) {
            if (i == index1 || i == index2) {
                System.out.print("[" + arr[i] + "] ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
