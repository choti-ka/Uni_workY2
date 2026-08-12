public class Student implements Comparable<Student> {
    private String name;
    private double gpa;  // คะแนนเฉลี่ย

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return name + " (GPA: " + gpa + ")";
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
