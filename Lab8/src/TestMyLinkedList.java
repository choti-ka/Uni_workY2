public class TestMyLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Start : size = " + list.size());

        list.add("Hello");
        list.add(new String("Hello"));
        list.add("Sawasdee");
        list.add("Mingalaba");
        list.add("Sabaidee");

        System.out.println("After add : list = " + list);

        list.add(1, "Bonjour");
        list.add(0,"Goodbye");

        System.out.println("After add by index : list = " + list);

        if (list.contains("hello") == true)
            System.out.println("\"hello\" is found.");
        else
            System.out.println("\"hello\" is not found.");

        if (list.contains("Sawasdee") == true)
            System.out.println("\"Sawasdee\" is found.");
        else
            System.out.println("\"Sawasdee\" is not found.");

        int pos = list.indexOf("Hello");
        if (pos != -1)
            System.out.println("\"Hello\" is found at index No." + pos);
        else
            System.out.println("\"Hello\" is not found.");

        pos = list.lastIndexOf("Hello");
        if (pos != -1)
            System.out.println("\"Hello\" is found at index No." + pos);
        else
            System.out.println("\"Hello\" is not found.");

        String str = list.remove(2).toString();
        System.out.println(str + " has been removed.");

        System.out.println("After remove index 2 : list = " + list);

        list.remove("Hello");

        System.out.println("After remove Hello : list = " + list);

        System.out.println("size = " + list.size());

        System.out.println("Show data in list using get() : ");
        for (int i=0;i<list.size();i++)
            System.out.print(list.get(i) + " ");


        list.set(0, "Sosadai");

        System.out.println();
        System.out.println("After set : list = " + list);

        LinkedList  anotherList = list.subList(1, 3);
        System.out.println("After sublist : list = " + list);
        System.out.println("After sublist : another list = " + anotherList);

        Object[] arr = list.toArray();

        System.out.print("Data in array : ");
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        list.clear();

        System.out.println("After clear : list = " + list);
    }
}

