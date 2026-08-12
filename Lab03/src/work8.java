import java.util.*;

public class work8 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of data : ");
        int datanum = input.nextInt();
        int [] data = new int[datanum];

        for(int i=0;i<data.length;i++){
            System.out.print("Enter data #"+(i+1)+" :");
            int dataans = input.nextInt();
            data[i] = dataans;
        }
        int Max = findMax(data);
        System.out.println("Maximum = "+Max);
        int Min = findMin(data);
        System.out.println("Minimum = "+Min);

        input.close();
    }
    public static int findMax(int[] data){
        int findmax = data[0];
        for(int read:data){
            if(read>findmax){
                findmax = read;
            }
        } return findmax;
    }
    public static int findMin(int[] data){
        int findMin = data[0];
        for(int read:data){
            if(read<findMin){
                findMin = read;
            }
        } return findMin;
    }
}
