package denysyerchenko;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamApplication {
    public static void main(String[] args) {
        List<Device> devicesList = new ArrayList();
        devicesList.add(new Device(9842520351L, "Apple", "iPhone 11 Max pro", 1182));
        devicesList.add(new Device(9939741187L, "Samsung", "Microwave oven 230M", 369));
        devicesList.add(new Device(8649874542L, "Samsung", "Galaxy note 333", 350));
        devicesList.add(new Device(9272368081L, "LG", "Smart TV N140", 659));
        devicesList.add(new Device(9493736531L, "LG", "CoffeeMaker CBVNG-11256", 410));
        devicesList.add(new Device(8998039568L, "Samsung", "Fitnes Tracker S3", 374));
        devicesList.add(new Device(8761722774L, "Apple", "AirPods", 931));
        devicesList.add(new Device(8689595242L, "Apple", "Air in a bottle", 1060));
        devicesList.add(new Device(9916427442L, "LG", "PowerBank 40 000 mAh", 857));
        devicesList.add(new Device(9236910372L, "Apple", "MacBook Pro 2020", 1500));

        while (true) {

            System.out.println("Press 1 to see all devices");
            System.out.println("Press 2 to add new device");
            System.out.println("Press 3 to find device by serial number");
            System.out.println("Press 4 to remove device with highest price");
            System.out.println("Press 5 to change brand of device");
            System.out.println("Press 6 to see devices with serial number contains 4 and with price higher than 800");

            Scanner optionScanner = new Scanner(System.in);
            int desiredOption = optionScanner.nextInt();

            switch (desiredOption) {
                case 1:
                    for (int i = 0; i < devicesList.size(); i++)
                        System.out.println(devicesList.get(i));
                    break;
                case 2:
                    System.out.println("Enter serial number");
                    long newSerialNumber = optionScanner.nextLong();
                    System.out.println("Enter brand");
                    String newBrand = optionScanner.next();
                    System.out.println("Enter info");
                    String newInfo = optionScanner.next();
                    System.out.println("Enter price");
                    int newPrice = optionScanner.nextInt();
                    devicesList.add(new Device(newSerialNumber, newBrand, newInfo, newPrice));
                    break;
                case 3:
                    System.out.println("Enter serial number");
                    long newSerialNumber2 = optionScanner.nextLong();

                    for (int j = 0; j < devicesList.size(); j++) {
                        if (newSerialNumber2 == devicesList.get(j).getSerialNumber()) {
                            System.out.println(devicesList.get(j));
                        }
                    }
                    break;
                    }

        }
    }
}