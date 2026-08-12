public class theMatrix {
    public static void main(String[] args){
        //range
        int[][] range = new int[3][3];
        //startNumber
        int number = 1;
        //matrix
        for (int i=0;i< range.length; i++){
            for (int j=0;j< range[i].length;j++){
                System.out.print(number+" ");
                number ++;
            }
            System.out.println();
        }
    }
}
