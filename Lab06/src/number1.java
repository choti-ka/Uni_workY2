import java.util.ArrayList;

public class number1 {
    private static ArrayList combineBetween(ArrayList i, ArrayList j) {
        int index = 1;
        for (int aa = 0; aa < j.size(); aa++) {
            if (index <= i.size()) {
                i.add(index, j.get(aa));
                index += 2;
            } else {
                i.add(j.get(aa));
            }
        }
        return i;
    }
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("apple");
        a.add("kiwi");
        a.add("orange");

        System.out.println("a = " + a);

        ArrayList c = new ArrayList();
        c.add("jane");
        c.add("john");
        c.add("robert");
        c.add("bob");
        c.add("peter");
        c.add("robert");
        c.add("bob");
        System.out.println("c = " + c);

        ArrayList h = combineBetween(a,c);
        System.out.println("h = " + h);
    }
}
