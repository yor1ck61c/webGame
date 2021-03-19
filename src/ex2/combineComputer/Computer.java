package ex2.combineComputer;

public class Computer {
    private CPU cpu;
    private EMS ems;
    private HardDisk hardDisk;

    public Computer(CPU cpu, EMS ems, HardDisk hardDisk) {
        this.cpu = cpu;
        this.ems = ems;
        this.hardDisk = hardDisk;
    }

    public void showInfo(){
        System.out.println("CPU的品牌是:" + cpu.getCpuBrand() + ", 主频是" + cpu.getFrequency()+"GHz");
        System.out.println("硬盘容量是:" + hardDisk.getCapacity() + "GB");
        System.out.println("内存容量是:" + ems.getSize()+"GB");
    }
}
