package ex2.rentCar;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入租赁天数:");
        int rentTime = scanner.nextInt();

        System.out.print("请输入要租赁的汽车类型（1.轿车  2.客车）：");
        String carType = null;
        if (scanner.nextInt() == 1) {
            carType = "轿车";
        } else carType = "客车";

        System.out.print("请输入要租赁的汽车类型（1.宝马  2.别克）：");
        String carBrand = null;
        int rentPrice;
        if (scanner.nextInt() == 1) {
            carBrand = "宝马";
            rentPrice = 500;
        } else {
            carBrand = "别克";
            System.out.print("请输入轿车的型号2、商务仓GL8 3、林荫大道：");
            if (scanner.nextInt() == 2){
                rentPrice = 600;
            }else rentPrice = 300;
        }
        Rent car = new Rent(carType,carBrand,rentTime,rentPrice,"京BK5543");
        System.out.println(car.toString());

    }


}
