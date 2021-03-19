package ex2.combineComputer;

public class softwareEngineer implements explainBusiness,writeCode {
    private String name;

    public softwareEngineer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo(){
        System.out.println("我是一名软件工程师，我的名字叫"+name);
    }
    @Override
    public void explainBusiness() {
        System.out.println("我会讲解业务");
    }

    @Override
    public void writeCode() {
        System.out.println("我会写代码");
    }
}
