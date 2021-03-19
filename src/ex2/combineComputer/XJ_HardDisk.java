package ex2.combineComputer;

public class XJ_HardDisk implements HardDisk{
    private int capacity;

    public XJ_HardDisk(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
