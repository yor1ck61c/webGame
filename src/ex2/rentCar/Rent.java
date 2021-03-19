package ex2.rentCar;

public class Rent extends Car {
    private int rentPrice;
    private String carNum;

    public Rent(String carType, String carBrand, int rentTime, int rentPrice, String carNum) {
        super(carType, carBrand, rentTime);
        this.rentPrice = rentPrice;
        this.carNum = carNum;

    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    @Override
    public String toString() {
        return "车牌号为"+carNum+", 租金为"+super.getRentTime() * rentPrice;
    }
}
