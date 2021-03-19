package ex2;

import java.util.Scanner;

public class compare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int[] t = new int[4];
        t[0] = a;
        t[1] = b;
        t[2] = c;
        t[3] = d;
        for(int i = 0 ; i < t.length; i++){
            for(int j = 0 ; j < t.length ; j++){
                int temp;
                if(t[i] > t[j]){
                    temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }
        a = t[0];
        b = t[1];
        c = t[2];
        d = t[3];
        System.out.println(a + " " + b + " "+ c + " " + d);


    }


}
