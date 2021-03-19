package ex2.Homework611;

public class Student {
    private long studentId;
    private String name;
    private int age;
    private int mark;

    public Student(long studentId, String name, int age, int mark) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }
}
