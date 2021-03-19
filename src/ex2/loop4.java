package ex2;

public class loop4 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            sum += i;
            if (sum >= 700){
                System.out.println(i);
                break;
            }
        }
    }
}
