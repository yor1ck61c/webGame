package ex2.combineComputer;

public class JSD_EMS implements EMS{

    private int size;

    public JSD_EMS(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
