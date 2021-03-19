package ex2;

import java.util.Scanner;

public class month {

    public static boolean isLeapYear(int year){   //闰年返回true 平年返回false
        return year%400 == 0 || year%4 == 0 && year%100 != 0;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: month = 31; break;
            case 4:
            case 6:
            case 9:
            case 11: month = 30; break;
            case 2:if (isLeapYear(year)) month=29;else month = 28;break;
            default:
                System.out.println("请输入正确的月份");
        }
        System.out.println(month);
    }
}
