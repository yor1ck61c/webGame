package ex2.Homework611;

import java.util.List;

public class test {

    public static void main(String[] args) {
        Class aClass = new Class(2001);
        Class bClass = new Class(2002);
        aClass.addStudent(new Student(20200210,"弗拉基米尔",18, 100 ));
        System.out.println(aClass.findStudentByName("弗拉基米尔").toString());
        aClass.updateStudentInfoByStudentId(20200210,new Student(20200210,"德莱厄斯",20,100));
        System.out.println(aClass.findStudentByName("德莱厄斯"));
        aClass.deleteStudent(0);
        List<Student> allStudent = aClass.findAllStudent();
        System.out.println(allStudent.toString());
    }


}
