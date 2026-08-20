import java.util.*;


public class ArrayList<T> {
    private T[] data=null;
    int numData;

    public ArrayList() {
        data =  (T[]) new Object[10];
        numData=0;
    }
    public void add(T obj) {
        if (numData >= data.length) {
            //เพิ่มพื้นที่ 2 เท่าจากเดิม
            Object[] tmpData = new Object[data.length*2];
            //ย้ายของจากบ้านเดิมเข้าบ้านหลังใหม่
            for (int i=0;i<data.length;i++)
                tmpData[i] = data[i];
            //เก็บบ้านเลขที่หลังใหม่แทน
            data = (T[]) tmpData;
        }
        data[numData] =obj;
        numData++;
    }
    public void add(int index,Object obj) {
        if (numData >= data.length) {
            //เพิ่มพื้นที่ 2 เท่าจากเดิม
            Object[] tmpData = new Object[data.length*2];
            //ย้ายของจากบ้านเดิมเข้าบ้านหลังใหม่
            for (int i=0;i<data.length;i++)
                tmpData[i] = data[i];
            //เก็บบ้านเลขที่หลังใหม่แทน
            data = (T[]) tmpData;
        }


        for (int i=numData-1;i>=index;i--)
            data[i+1] = data[i];


        data[index] = (T) obj;
        numData++;
    }
    public void addAll(ArrayList otherList) {
        for (int i=0;i<otherList.size();i++)
            this.add((T) otherList.get(i));
    }
    public Object get(int index) {
        return data[index];
    }
    public int size() {
        return numData;
    }
    public String toString() {
        String str="[";
        for (int i=0;i<numData-1;i++) {
            str = str + data[i] + ", ";
        }
        if (numData > 0)
            str = str + data[numData-1] + "]";
        else str = str +  "]";
        return str;
    }
    // ตรวจสอบว่ามีข้อมูล str อยู่ในลิสต์หรือไม่
    public boolean contains(String str) {
        return indexOf(str) != -1;
    }
    // ค้นหาตำแหน่ง (index) แรกที่พบข้อมูล ถ้าไม่เจอจะคืนค่า -1
    public int indexOf(String str) {
        for (int i = 0; i < numData; i++) {
            if (data[i] != null && data[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // เช็กว่าลิสต์ว่างเปล่าหรือไม่ (ไม่มีข้อมูลเลย)
    public boolean isEmpty() {
        return numData == 0;
    }
    // ค้นหาตำแหน่ง (index) สุดท้ายที่พบข้อมูล โดยวนลูปจากหลังมาหน้า
    public int lastIndexOf(String str) {
        for (int i = numData - 1; i >= 0; i--) {
            if (data[i] != null && data[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
    // ลบข้อมูล ณ ตำแหน่ง pos แล้วขยับข้อมูลตัวถัดๆ ไปมาทางซ้าย
    public void remove(int pos) {
        if (pos < 0 || pos >= numData) {
            return;
        }
        for (int i = pos; i < numData - 1; i++) {
            data[i] = data[i + 1];
        }
        data[numData - 1] = null; // ล้างค่าตัวท้ายสุด
        numData--;
    }
    // ลบข้อมูลทุกตัวที่มีอยู่ใน list4 ออกจากลิสต์นี้
    public void removeAll(ArrayList list4) {
        for (int i = 0; i < numData; i++) {
            if (data[i] != null && list4.contains(data[i].toString())) {
                remove(i);
                i--; // ถอย index กลับ 1 เพื่อตรวจข้อมูลตัวใหม่ที่เพิ่งเลื่อนมาแทนที่
            }
        }
    }
    // เก็บไว้เฉพาะข้อมูลที่มีอยู่ใน list2 (ตัวอื่นลบทิ้งทั้งหมด)
    public void retainAll(ArrayList list2) {
        for (int i = 0; i < numData; i++) {
            if (data[i] != null && !list2.contains(data[i].toString())) {
                remove(i);
                i--; // ถอย index กลับ 1 เพื่อตรวจข้อมูลตัวใหม่ที่เพิ่งเลื่อนมาแทนที่
            }
        }
    }
    // เปลี่ยนแปลงข้อมูล ณ ตำแหน่ง index ให้เป็น setTo
    public void set(int index, String setTo) {
        if (index >= 0 && index < numData) {
            data[index] = (T) setTo;
        }
    }
}
