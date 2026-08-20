import java.util.*;
import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        Scanner kb = new Scanner(System.in);
        String str;
        int pos;

        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);

        list.add("Mingalaba");
        list.add("Bonjour");
        list.add("Hello");

        System.out.println("---- After add ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);

        list.add("Mingalaba");
        list.add("Bonjour");
        list.add("Hello");
        list.add("Mingalaba");
        list.add("Bonjour");
        list.add("Hello");
        list.add("Mingalaba");
        list.add("Bonjour");
        list.add("Hello");

        System.out.println("---- After add 2 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);

        list.add("Sawasdee");

        System.out.println("---- After add ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);

        str = "bonjour";
        if (list.contains(str))
            System.out.println(str + " is found in list.");
        else
            System.out.println(str + " is not found in list.");

        ArrayList list2 = new ArrayList();
        list2.add("Sayonara");
        list2.add("Lakon");
        list2.add("Goodbye");

        list.addAll(list2);

        System.out.println("---- After addAll ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);

        list.addAll(1,list2);
        // no 1
        System.out.println("---- After addAll item 1 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        // no 2
        ArrayList list3;
        list3 = (ArrayList) list2.clone();
        System.out.println("---- After clear item 2----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);
        list3.add("Yoohoo");
        System.out.println("list3 = " + list3);
        //no 3
        System.out.println("---- Item 3 ----");
        str = "Bonjour";
        pos = list.indexOf(str);
        if(pos!=-1){
            System.out.println(str + " is found at index no. " + pos);
        } else {
            System.out.println(str + " is not found.");
        }
        //no 4
        System.out.println("------- item 4 -------");
        if (list2.isEmpty())
            System.out.println("List is empty.");
        else
            System.out.println("List is not empty.");
        ArrayList list7 = new ArrayList();
        if (list7.isEmpty())
            System.out.println("List is empty.");
        else
            System.out.println("List is not empty.");
        //no 5
        System.out.println("------- item 5 -------");
        str = "Hello";
        pos = list.lastIndexOf(str);
        if (pos != -1)
            System.out.println(str + " is found at index no. " + pos);
        else
            System.out.println(str + " is not found.");
        //no 6
        pos = 5;
        list.remove(pos);

        System.out.println("---- item 6 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        //no 7
        str = "Hello";
        list.remove(str);
        System.out.println("---- item 7 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        //no 8
        ArrayList list4 = new ArrayList();
        list4.add("Sayonara");
        list.removeAll(list4);
        System.out.println("---- item 8 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list4 = " + list4);
        //no 9
        list.retainAll(list2);
        System.out.println("---- item 9 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        //no 10
        list.set(2, "Yoohoo");
        System.out.println("---- item 10 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        //no 11
        List list5 = list.subList(1, 3);
        System.out.println("---- item 11 ----");
        System.out.println("list size = " + list.size());
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);
        System.out.println("list5 = " + list5);
        //no 12
        System.out.println("------- item 12 -------");
        Object[] arr;

        arr = list.toArray();
        for (int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }

}