public class TestBoxArray {

    public static void main(String a[]){

        BoxArray<String> b = new BoxArray<String>();

        b.add("yoohoo");
        b.add("bonjour");
        b.add("byebye");

        for (int i=0;i<b.size();i++) {
            System.out.println(b.getData(i)+ " ");
        }
    }
}
