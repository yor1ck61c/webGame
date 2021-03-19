package ex2.dog;

import java.util.Scanner;

public class testMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎您来到宠物店！");
        // 1、 输入宠物名称
        System.out.print("请输入要领养宠物的名字：");
        String name = input.next();
        // 2、 选择宠物类型
        System.out.print("请选择要领养的宠物类型：（1、狗狗 2、企鹅）");
        switch (input.nextInt()) {
            case 1:
                // 如果是狗狗,选择狗狗品种
                System.out.print("请选择狗狗的品种:(1、聪明的拉布拉多犬" +
                        " 2、酷酷的雪娜瑞)");
                String strain = null;
                if (input.nextInt() == 1) {
                    strain = "聪明的拉布拉多犬";
                } else {
                    strain = "酷酷的雪娜瑞";
                }
                System.out.print("请输入狗狗的健康值（1~100之间）：");
                int health=input.nextInt();
                // 创建狗狗对象并赋值
                Dog dog = new Dog();
                dog.setName(name);
                dog.setStrain(strain);
                dog.setHealth(health);
                // 输出狗狗信息
                dog.print();
                break;
        }
    }
}
