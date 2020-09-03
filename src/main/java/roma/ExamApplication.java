package roma;

import java.io.IOException;
import java.util.Scanner;

public class ExamApplication {
    public static void main(String[] args) throws IOException {
        Device device = new Device();
        Scanner sc = new Scanner(System.in);
        device.ReadDevice();
        boolean b = true;
        while (b){
            info();
            System.out.println("Виберіть опцію");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    device.getAllDevices();
                    break;
                case 2:
                    device.addNewDevice();
                    break;
                case 3:
                    device.findDeviceBySerialNumber();
                    break;
                case 4:
                    device.removeMostExpensiveDevice();
                    break;
                case 5:
                    device.replaceBrand();
                    break;
                case 6:
                    device.getAllBrandsByNumberandPrice();
                    break;
                case 7:
                    System.exit(0);
            }
        }

    }
    static void info(){
        System.out.println("Введіть 1 щоб получити всі девайси");
        System.out.println("Введіть 2 щоб додати новий девайс");
        System.out.println("Введіть 3 щоб найти девайс за серійним номером");
        System.out.println("Введіть 4 щоб видалити самий дороги девайс");
        System.out.println("Введіть 5 замінити один бренд на свій");
        System.out.println("Введіть 6 щоб дістати всі типи девайсів за номером і ціною");
        System.out.println("Введіть 7 щоб завершити роботу");
    }


}
