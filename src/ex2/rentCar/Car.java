package ex2.rentCar;

public class Car {
    private String carType;
    private String carBrand;
    private int rentTime;

    public Car(){}

    public Car(String carType, String carBrand, int rentTime) {
        this.carType = carType;
        this.carBrand = carBrand;
        this.rentTime = rentTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }
}
