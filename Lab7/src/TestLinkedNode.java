public class TestLinkedNode {
    public static void main(String[] args) {
        Node a,b,c;

        a = new Node();
        a.data = 6;

        b = new Node();
        b.data = 8;

        c = new Node();
        c.data = 1;

        a.next = b;
        b.next = c;

        b = null;
        c = null;

        Object num = 8;
        Node tmp;
        tmp = a;
        if (tmp!=null && (tmp.data).equals(num)) {
            a = tmp.next;
        }
        else {
            while (tmp!=null) {
                if (((tmp.next).data).equals(num)) {
                    tmp.next = tmp.next.next;
                    break;
                }
                tmp = tmp.next;
            }
        }

        tmp = a;
        while(tmp!=null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }
}
