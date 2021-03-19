package ex2;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws invalidAgeException {
        if(age < 1 || age > 100){
            throw new invalidAgeException("请输入介于1-100之间的年龄!");
        }else
            this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.setAge(120);
        }catch (invalidAgeException e){
            System.out.println(e.getMessage());
        }
        System.out.println(person.getAge());
    }
}
