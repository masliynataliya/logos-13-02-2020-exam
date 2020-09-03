package mykola.prysiazhniuk;

import java.util.Comparator;

public class Device {

    private long serialNumber;
    private String brand;
    private String info;
    private int price;

    public Device(long serialNumber, String brand, String info, int price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.info = info;
        this.price = price;
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

}
