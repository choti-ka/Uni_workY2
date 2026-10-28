public class Test3 {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("ก่อนเรียงลำดับ:");
        printArray(numbers);

        System.out.println("\nเริ่มต้นเรียงลำดับด้วย Merge Sort:");
        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\nหลังเรียงลำดับจากน้อยไปมาก:");
        printArray(numbers);
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //left
            System.out.println("\nLeft : left = " + left + ", mid = " + mid);
            printArrayRange(arr, left, mid);
            mergeSort(arr, left, mid);

            // right
            System.out.println("\nRight : mid + 1 = " + (mid + 1) + ", right = " + right);
            printArrayRange(arr, mid + 1, right);
            mergeSort(arr, mid + 1, right);

            System.out.println("\n left = " + left + ", mid = " + mid + ", right = " + right);
            merge(arr, left, mid, right);
            printArrayRange(arr, left, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {arr[k] = L[i]; i++;
            } else {arr[k] = R[j]; j++;
            }
            k++;
        }
        //left
        while (i < n1) {arr[k] = L[i]; i++; k++;
        }
        //right
        while (j < n2) {arr[k] = R[j]; j++; k++;
        }
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void printArrayRange(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
