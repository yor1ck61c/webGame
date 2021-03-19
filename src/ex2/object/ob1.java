package ex2.object;

public class ob1 {
    private String color;
    private String brand;
    private double price;

    public ob1(String color, String brand, double price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ob1{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public void swim(){}

    public static void main(String[] args) {
        ob1 ob = new ob1("白色","西门子",19.9);
        ob.swim();
        System.out.println(ob.toString());
    }
}
