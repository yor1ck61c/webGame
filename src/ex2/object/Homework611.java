package ex2.object;

import java.util.Scanner;

public class Homework611 {

    public static boolean isPrime(int n) {     //第二题
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

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;
        if (n > 0){   //第一题
            for (int i = 1; i <= n ; i++) {
                sum += i;
            }
            System.out.println(sum);
        }else if (n < 0){
            for (int i = 1; i <= 100 ; i++) {
                if (i % 2 == 0)
                    System.out.print(i + "\t");
                if (i % 10 == 0)
                    System.out.println();
            }
        }else System.out.println(n);

        System.out.println(isPrime(2));
        System.out.println(isPrime(6));
    }



}
