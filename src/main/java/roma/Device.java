package roma;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Device {
    Scanner sc = new Scanner(System.in);
    private long serialNumber;
    private String brand;
    private String info;
    private int price;
    private List<Device> devices = new ArrayList<>();
    public Device() {

    }

    public Device(long serialNumber, String brand, String info, int price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.info = info;
        this.price = price;

    }

    static boolean ifNumberPresentInInteger(long serialNumber, int number) {
        String intValue = String.valueOf(serialNumber);
        String intNumberValue = String.valueOf(number);
        return intValue.contains(intNumberValue);
    }

    public String getInfo() {
        return info;
    }

    public Device setInfo(String info) {
        this.info = info;
        return this;
    }

    public void replaceBrand() {
        System.out.println("Введіть який бренд хочете замінити");
        String name = sc.next();
        System.out.println("Виберіть ім'я на яке хочете замінити");
        String name1 = sc.next();
        devices.stream().filter(test1 -> test1.getBrand().contains(name)).forEach(test1 -> test1.setBrand(name1));
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

    public long getSerialNumber() {
        return serialNumber;
    }

    public Device setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Device setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Device setPrice(int price) {
        this.price = price;
        return this;
    }

    public void addNewDevice() {
        Device device = new Device();
        System.out.println("Введіть серійний номер");
        long serialNumber = sc.nextLong();
        System.out.println("Введіть назву бренду");
        String brand = sc.next();
        System.out.println("Введіть опис предмета ");
        String info = sc.next();
        System.out.println("Введіть ціну предмета");
        int price = sc.nextInt();
        device.setBrand(brand);
        device.setInfo(info);
        device.setPrice(price);
        device.setSerialNumber(serialNumber);
        devices.add(device);

    }

    public void findDeviceBySerialNumber() {
        System.out.println("Введіть серійний номер");
        long serialNumber = sc.nextLong();
        List<Device> collect = devices.stream()
                .filter(device -> device.getSerialNumber() == serialNumber)
                .collect(Collectors.toList());
        if (!collect.isEmpty()) {
            System.out.println(collect.get(0).toString());
        } else throw new NoDeviceWithSerialNumber();


    }

    public void removeMostExpensiveDevice() {
        Optional<Device> max = devices.stream().max(Comparator.comparingInt(Device::getPrice));
        max.ifPresent(device -> devices.remove(device));

    }

    public void getAllDevices() throws IOException {
        devices.forEach(System.out::println);
    }

    public void ReadDevice() throws IOException {
        FileInputStream fstream = new FileInputStream("DeviceDetails.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        List<Device> devices1 = new ArrayList<>();

        while ((strLine = br.readLine()) != null) {
            String device = strLine;
            device = device.replace(" ", "");
            device = device.replace(" ", "");
            String[] attibute = device.split(",");
            devices1.add(new Device().setSerialNumber(Long.parseLong(attibute[0])).setBrand(attibute[1]).setInfo(attibute[2])
                    .setPrice(Integer.parseInt(attibute[3])));
        }

        devices.addAll(devices1);
        devices.sort(Comparator.comparing(Device::getBrand));
        fstream.close();
    }

    public void getAllBrandsByNumberandPrice() {
        devices.stream().filter(device -> ifNumberPresentInInteger(device.getSerialNumber(), 4)
                & device.getPrice() > 800).forEach(device -> System.out.println(device.getInfo()));
    }
}

