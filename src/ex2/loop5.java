package ex2;

import java.util.Scanner;

public class loop5 {
    public static void main(String[] args) {
        int[] a = new int[5];
        double sum = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5 ; i++) {
            a[i] = input.nextInt();
            sum += a[i];
        }
        int min = a[0];
        for (int i = 1; i < 5 ; i++) {
            if (a[i] < min)
                min = a[i];
        }
        System.out.println("平均数:" + sum/5);
        System.out.println("最小数:" + min);
    }
}
