package ex2.object;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compare(int a, int b){
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Student student = new Student("弗拉基米尔", 20);
        System.out.println(student.toString());
        System.out.println(student.compare(3,5));
    }
}
