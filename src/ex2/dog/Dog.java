package ex2.dog;

public class Dog {

    private String name = "无名氏"; // 昵称
    private int health = 0; // 健康值
    private int love = 0; // 亲密度
    private String strain = "聪明的拉布拉多犬"; // 品种

    /**
     * 通过吃饭增加健康值。
     */
    public void eat() {
        if (health >= 100) {
            System.out.println("狗狗需要多运动呀！");
        } else {
            health = health + 3;
            System.out.println("狗狗吃饱饭了！");
        }
    }

    /**
     * 通过玩游戏增加与主人亲密度，减少健康值。
     */
    public void play() {
        if (health < 60) {
            System.out.println("狗狗生病了！");
        } else {
            System.out.println("狗狗正在和主人玩耍。");
            health = health - 10;
            love = love + 5;
        }
    }

    /**
     * 设置狗狗昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置狗狗健康值
     */
    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            System.out.println("健康值应该在0至100之间，默认值为60。");
            this.health = 60;
            return;
        }
        this.health = health;
    }

    /**
     * 设置狗狗亲密度
     */
    public void setLove(int love) {
        if (love < 0 || love > 100) {
            System.out.println("亲密度应该在0至100之间，默认值为0。");
            this.love = 0;
        }
        this.love = love;
    }

    /**
     * 设置狗狗品种
     */
    public void setStrain(String strain) {
        this.strain = strain;
    }

    /**
     * 读取狗狗昵称
     *
     * @return 昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 读取狗狗健康值
     *
     * @return 健康值
     */
    public int getHealth() {
        return health;
    }

    /**
     * 读取狗狗亲密度
     *
     * @return 亲密度
     */
    public int getLove() {
        return love;
    }

    /**
     * 读取狗狗品种
     *
     * @return 品种
     */
    public String getStrain() {
        return strain;
    }

    /**
     * 输出狗狗的信息
     */
    public void print() {
        System.out.println("宠物的自白：\n我的名字叫" + this.getName()
                + "，健康值是" + this.getHealth() + "，和主人的亲密度是"
                + this.getLove() + "，我是一只 " + this.getStrain() + "。");
    }

}
