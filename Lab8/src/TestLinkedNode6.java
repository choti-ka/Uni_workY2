public class TestLinkedNode6 {
    public static void main(String[] args) {
        Node a,b,c,d;

        a = new Node();
        a.data = 4;

        b = new Node();
        b.data = 6;

        c = new Node();
        c.data = 1;

        d = new Node();
        d.data = 3;

        a.next = b;
        b.next = c;
        c.next = d;

        b = null;
        c = null;
        d = null;

        System.out.println("=====Before add data======");
        System.out.println("Show all data in linked node.");
        Node tmp = a;
        while(tmp!=null) {
            System.out.println("data = " + tmp.data);
            tmp = tmp.next;
        }

        Node n;
        n = new Node();
        n.data = 7;

        n.next = a;
        a = n;

        System.out.println("=====After add data======");
        System.out.println("Show all data in linked node.");
        tmp = a;
        while(tmp!=null) {
            System.out.println("data = " + tmp.data);
            tmp = tmp.next;
        }

    }
}
