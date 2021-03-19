package ex2;

public class Homework610 {

    public static void printDelta(){    //第一题
        for (int i = 0; i < 5 ; i++) {
            for (int j = 1; j <= 9 ; j++) {
                if(j == 5-i || j == 5+i)
                    System.out.print("*");
                else if (i == 4)
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int getFactorial(int n){//第二题
        int sum = 1;
        while (n > 0){
            sum *= n;
            n--;
        }
        return sum;
    }

    public static int getFactorialSum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getFactorial(i);
        }
        return sum;
    }

    public static void printMultiplicationTable(){//第三题
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j+" * "+i+" = "+ i*j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactorialSum(10));
    }
}
