package ex2;

public class Student {

    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int multiplication(int n){     //阶乘
        int sum = 1;
        for (int i = 2; i <= n ; i++) {
            sum *= i;
        }
        return sum;
    }

    public boolean isPrime(int n) {     //质数
        if (n <= 3) {
            return n > 1;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int gcd( int x , int y ) {             //最大公约数
        return y != 0 ? gcd( y , x % y ) : x ;
    }

    public int lcm(int a,int b) {          //最小公倍数
        return a*b/gcd(a,b);
    }

    public int fibonacci(int n){          //斐波那契数列
        return n == 0 ? 0 : (n == 1 ? 1 : fibonacci(n-2) +  fibonacci( n-1));
    }

    public static void main(String[] args) {
        Student student = new Student("弗拉基米尔", 20, "male");
        System.out.println(student.toString());
        System.out.println(student.multiplication(3));
        System.out.println(student.isPrime(2));
        System.out.println(student.isPrime(3));
        System.out.println(student.gcd(15,33));
        System.out.println(student.lcm(15,33));
        System.out.println(student.fibonacci(4));
    }






}
