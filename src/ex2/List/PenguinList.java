package ex2.List;

import java.util.ArrayList;
import java.util.List;

public class PenguinList {
    public static void main(String[] args) {
        List<Penguin> penguinList = new ArrayList<Penguin>();
        penguinList.add(new Penguin("欧欧", "Q仔"));
        penguinList.add(new Penguin("亚亚", "Q妹"));
        penguinList.add(new Penguin("菲菲", "Q妹"));
        penguinList.add(new Penguin("美美", "Q妹"));

        System.out.println(penguinList.size());
        System.out.println(penguinList.toString());

        penguinList.remove(new Penguin("菲菲", "Q妹"));
        penguinList.remove(new Penguin("美美", "Q妹"));
        System.out.println("删除两只企鹅后还有"+penguinList.size()+ "只企鹅");
        System.out.println(penguinList.toString());

        if(penguinList.contains(new Penguin("美美", "Q妹")))
            System.out.println("集合中包含美美的信息");
        else
            System.out.println("集合中不包含美美的信息");
    }
}
