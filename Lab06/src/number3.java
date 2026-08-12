import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class number3 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Somchai", 3.25));
        students.add(new Student("Anan", 2.75));
        students.add(new Student("Ben", 3.90));
        students.add(new Student("Duang", 3.00));

        System.out.println("ก่อนเรียงลำดับ:");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students);  // ใช้ compareTo()

        System.out.println("\nหลังเรียงตามชื่อ:");
        for (Student s : students) {
            System.out.println(s);
        }

        students.sort(Comparator.comparing(Student::getGpa).reversed());

        System.out.println("\nหลังเรียงตาม GPA (มากไปน้อย):");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
