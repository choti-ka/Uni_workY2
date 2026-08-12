public class ArrayTest {
    public static void main(String[] args) {

        int[] score = {70, 80, 90, 85, 75};

        for(int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }

        int sum = 0;

        for(int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        double avg = (double)sum / score.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}