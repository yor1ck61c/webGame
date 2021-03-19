package ex2.combineComputer;

public class IntelCPU implements CPU {
    private String brand;
    private Float frequency;

    public IntelCPU(String brand, Float frequency) {
        this.brand = brand;
        this.frequency = frequency;
    }

    @Override
    public String getCpuBrand() {
        return brand;
    }

    @Override
    public Float getFrequency() {
        return frequency;
    }
}
