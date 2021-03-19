package ex2;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class log4j {

    private static Logger logger = Logger.getLogger(log4j.class);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入一个被除数:");
            int num = input.nextInt();
            System.out.print("请输入一个被除数：");
            int wasDivided = input.nextInt();
            System.out.println(num/wasDivided);
        } catch (Exception e){
            logger.error("被除数和除数必须是整数，被除数不能为零");
            e.printStackTrace();
        } finally {
            System.out.println("感谢使用本程序！");
        }
    }
}
