package ex2;

public class loop2 {

    public static int count(){
        int b = 1, sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            sum += b * i;
            b *= -1;
        }
        return sum;
    }

    public static double count2(){
        double sum = 0, up = 1.0;
        for (int i = 1; i <= 100 ; i++) {
            sum += up/i;
        }
        return sum;
    }

    public static double count3(){
        double sum = 0, up = 1.0;
        for (int i = 1; i < 10 ; i++) {
            sum += up/Math.pow(i,2);
        }
        return sum;
    }

    public static int count4(){
        int sum = 1;
        for (int i = 2; i < 10 ; i++) {
            sum *= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(count());
        System.out.println(count2());
        System.out.println(count3());
        System.out.println(count4());
    }
}
