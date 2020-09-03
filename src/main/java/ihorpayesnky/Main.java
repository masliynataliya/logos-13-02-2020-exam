package ihorpayesnky;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws FileNotFoundException, MyException {
        Scanner scanner = new Scanner(System.in);

        List<Device> devices = Dir.readDevices();

        while (true) {
            System.out.println();
            System.out.println("1 - show devices");
            System.out.println("2 - add new device");
            System.out.println("3 - get device by serial number");
            System.out.println("4 - remove the richer device");
            System.out.println("5 - change brand name");
            System.out.println("6 - get devices with specify condition");
            System.out.println("7 - exit");
            System.out.println();
            System.out.print("Enter option >> ");
            String option = scanner.next();

            switch (option) {
                case "1":
                    devices.stream().sorted().forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Add new device: ");
                    System.out.print("Enter serial number >> ");
                    long serialNumber = scanner.nextInt();

                    boolean isExist = devices.stream().anyMatch(x -> x.getSerialNumber() == serialNumber);
                    if (isExist) {
                        System.out.println("That serial number is exist...");
                        break;
                    }

                    System.out.print("Enter brand >> ");
                    String brand = scanner.next();

                    System.out.print("Enter info >> ");
                    String info = scanner.next();

                    System.out.print("Enter price >> ");
                    int price = scanner.nextInt();

                    System.out.println("Added new device successful");
                    devices.add(new Device(serialNumber, brand, info, price));

                    break;
                case "3":
                    if (devices.isEmpty()) {
                        System.out.println("Device list is empty...");
                        break;
                    }

                    System.out.print("Enter serial number >> ");
                    int serialN = scanner.nextInt();

                    if (devices.stream()
                            .noneMatch(x -> x.getSerialNumber()==serialN)) {
                        throw new MyException("NOT FOUND SERIAL NUMBER!!!!");
                    }

                    System.out.println(devices.stream()
                            .filter(x -> x.getSerialNumber() == serialN)
                            .findFirst()
                            .get().toString());
                    break;
                case "4":
                    if (devices.isEmpty()) {
                        System.out.println("Device list is empty...");
                        break;
                    }
                    Device device = devices.stream().max(new DevicePriceComparing()).get();
                    System.out.println("Device was removed: " + device.toString());
                    devices.remove(device);
                    break;
                case "5":
                    if (devices.isEmpty()) {
                        System.out.println("Device list is empty...");
                        break;
                    }
                    System.out.print("Enter brand name >> ");
                    String brandName = scanner.next();

                    if (devices.stream()
                            .noneMatch(x -> x.getBrand().equalsIgnoreCase(brandName))) {
                        System.out.println("That brand is not exist...");
                    }

                    System.out.print("Enter new brand name >> ");
                    String brandNew = scanner.next();

                    devices.stream()
                            .filter(x -> x.getBrand().equalsIgnoreCase(brandName))
                            .forEach(x -> x.setBrand(brandNew));

                    System.out.println("Brand " + brandName + " was renamed to " + brandNew);
                    break;
                case "6":
                    if (devices.isEmpty()) {
                        System.out.println("Device list is empty...");
                        break;
                    }
                    devices.stream()
                            .filter(x -> String.valueOf(x.getSerialNumber()).contains("4")
                                    && x.getPrice() >= 800)
                            .forEach(x -> System.out.println(x.getInfo()));
                    break;
                case "7":
                    System.out.println("Close session...");
                    System.exit(0);
                default:
                    System.out.println("Option input error... Try again...");
            }
        }
    }
}
