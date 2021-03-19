package ex2;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        try{
            System.out.print("输入需要运算的第一个数字:");
            double firstNum = input.nextDouble();
            System.out.print("输入需要运算的第二个数字:");
            double secondNum = input.nextDouble();
            System.out.print("输入运算符(+,-,*,/):");
            String c = input.next();
            switch (c){
                case "+":
                    sum = firstNum + secondNum;break;
                case "-":
                    sum = firstNum - secondNum;break;
                case "*":
                    sum = firstNum * secondNum;break;
                case "/":
                    sum = firstNum / secondNum;break;
                default:
                    System.out.println("请输入正确的运算符");

            }
        }catch (Exception e){
            System.out.println("请输入正确的数字，除数不能为0");
        }finally {
            System.out.println(sum);
        }
    }
}
