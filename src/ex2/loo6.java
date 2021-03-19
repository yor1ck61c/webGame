package ex2;

import java.util.Scanner;

public class loo6 {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        char[] chars = s.toCharArray();
        char c = input.next().charAt(0);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("你输入的不是小写字母！");
    }
}
