public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // เพิ่มข้อมูลต่อท้ายรายการ
    public void add(Object obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // เพิ่มข้อมูลแทรกที่ตำแหน่งที่ระบุ
    public void add(int index, Object obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node();
        newNode.data = obj;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // ลบข้อมูลทั้งหมด
    public void clear() {
        head = null;
        size = 0;
    }

    // ตรวจสอบว่ามีข้อมูลที่ระบุหรือไม่
    public boolean contains(Object obj) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(obj)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // ดึงข้อมูลที่ตำแหน่งที่ระปร
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // ค้นหาตำแหน่งแรกของข้อมูลที่ระบุ
    public int indexOf(Object obj) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // ตรวจสอบว่าลิงก์ลิสต์ว่างหรือไม่
    public boolean isEmpty() {
        return size == 0;
    }

    // ค้นหาตำแหน่งสุดท้ายของข้อมูลที่ระบุ
    public int lastIndexOf(Object obj) {
        Node current = head;
        int lastIndex = -1;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    // ลบข้อมูลที่ตำแหน่งที่ระบุ
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Object removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    // ลบข้อมูลที่ระบุ
    public boolean remove(Object obj) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(obj)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(obj)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // แทนที่ข้อมูลที่ตำแหน่งที่ระบุ
    public Object set(int index, Object obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Object oldData = current.data;
        current.data = obj;
        return oldData;
    }

    // ดึงขนาดของลิงก์ลิสต์
    public int size() {
        return size;
    }

    // สร้างรายการย่อย
    public LinkedList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        LinkedList subList = new LinkedList();
        Node current = head;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }
        return subList;
    }

    // แปลงเป็นอาร์เรย์
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
