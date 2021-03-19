package ex2;

import java.util.Scanner;

public class loop3 {
    public static void main(String[] args) {
        int j = 7;
        String space = "";
        for (int i = 0; i < 4 ; i++) {
            System.out.print(space);
            for (int k = j; k > 0 ; k--) {
                System.out.print("*");
            }
            System.out.print(space);
            System.out.println();
            space += " ";
            j -= 2;
        }
    }
}
