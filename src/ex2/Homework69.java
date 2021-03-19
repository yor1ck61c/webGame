package ex2;

public class Homework69 {

    public static boolean isDESC(int num){ return num/100 > num/10%10 && num/10%10 > num%10; }

    public static int buyPeach(int amount){  //买了几个桃
        return amount >= 3 ? (amount > 5 ? amount+2 : amount+1) :amount;
    }

    public static boolean isLeapYear(int year){   //闰年返回true 平年返回false
        return year%400 == 0 || year%4 == 0 && year%100 != 0;
    }

    public static void main(String[] args) {
        System.out.println(isDESC(531));
        System.out.println(isDESC(135));
        System.out.println(buyPeach(1));
        System.out.println(buyPeach(3));
        System.out.println(buyPeach(6));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2001));
    }






    //eg.求给的分数是否>60
    public static boolean Over60(int mark){
        return mark>60;
    }





}


