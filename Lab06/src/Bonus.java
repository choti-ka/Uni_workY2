import java.util.ArrayList;
import java.util.List;

public class Bonus {
    public static void main(String[] args){
        ArrayList a = new ArrayList();
        a.add("apple");
        a.add("kiwi");
        a.add("orange");

        System.out.println("a = "+a);

        ArrayList b = new ArrayList();
        System.out.println("b = "+b);

        ArrayList c = new ArrayList();
        c.add("jane");
        c.add("john");
        c.add("robert");
        c.add("bob");
        c.add("peter");
        c.add("robert");
        c.add("bob");
        System.out.println("c = "+c);

        ArrayList d = new ArrayList();
        d.add(28);
        d.add(25);
        d.add(17);
        d.add(33);
        d.add(12);
        System.out.println("d = "+d);

        ArrayList e = new ArrayList<>();
        e.add(18);
        e.add(33);
        e.add(19);
        e.add(17);
        e.add(45);
        e.add(33);
        e.add(28);
        System.out.println("e = "+e);

        d.trimToSize();
        System.out.print(d.size());
    }
}
