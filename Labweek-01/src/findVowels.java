import java.util.Locale;
import java.util.Scanner;

public class findVowels {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] vowels = {'a','e','i','o','u'};
        int count = 0;
        //input
        System.out.print("Enter your word : ");
        String word = input.nextLine().toLowerCase();

        //check vowels
        for (char alphabet: word.toCharArray()){
                for(int j=0;j<vowels.length;j++){
                    if(alphabet == vowels[j]){
                        count++;
                        break;
                    }
                }
        }
        //output
        System.out.println("Vowels = "+ count);
        input.close();
    }
}
