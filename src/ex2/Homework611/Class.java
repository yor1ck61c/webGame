package ex2.Homework611;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private long classId;
    private Student[] students = new Student[10];

    public Class(long classId) {
        this.classId = classId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
    }

    public void deleteStudent(int index){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && i == index)
                students[i] = null;
        }
    }

    public Student findStudentByName(String name){
        for (Student student : students) {
            if (student != null && student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudentInfoByStudentId(long studentId, Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && student.getStudentId() == studentId)
                students[i] = student;
        }
    }

    public List<Student> findAllStudent(){
        List<Student> studentsList = new ArrayList<>();
        for (Student student : students) {
            if (student != null) {
                studentsList.add(student);
            }
        }
        return studentsList;
    }
}
