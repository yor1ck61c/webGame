package ex2.combineComputer;

public class testMain {
    public static void main(String[] args) {
        IntelCPU intel = new IntelCPU("Intel", (float) 3.8);
        JSD_EMS jsd_ems = new JSD_EMS(4);
        XJ_HardDisk xj_hardDisk = new XJ_HardDisk(500);
        Computer computer = new Computer(intel,jsd_ems,xj_hardDisk);
        computer.showInfo();
    }
}
