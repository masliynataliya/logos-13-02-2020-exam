package mikeKhay;

public class Device implements Comparable<Device>{
    private long serialNumber;
    private String brand;
    private String info;
    private int price;

    public Device() {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.info = info;
        this.price = price;
    }

    public static void add(String line) {
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getInfo() {
        return info;
    }

    public int getPrice() {
        return price;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "serialNumber=" + serialNumber +
                ", brand='" + brand + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Device device) {
        return brand.compareTo(device.getBrand());
    }
}
