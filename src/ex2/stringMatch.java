package ex2;

public class stringMatch {

    public static int stringMatchTimes(String s1, String s2){
        int index = 0, count = 0;
        while ((index = s1.indexOf(s2,index)) != -1){
            index += 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "aaaabb,aa";
        String s2 = "aa";
        System.out.println(stringMatchTimes(s1,s2));

    }
}

