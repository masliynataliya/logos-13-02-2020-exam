package mikeKhay;

import java.io.*;
import java.util.*;

public class ExamApplication {
    public static void main(String[] args) throws IOException {
        while(true){

            BufferedReader bufReader = new BufferedReader(new FileReader("DeviceDetails.txt"));
            ArrayList<Device> devices = new ArrayList<>();

            String s = bufReader.readLine();
            while (s != null){
            String delimeter = ", ";
            String [] line = s.split(delimeter);
            Device device = new Device();
            devices.add(device);
            s = bufReader.readLine();
            }

            bufReader.close();


            System.out.println("Виберіть необхідний пункт.");
            System.out.println("1 - вивести всю колекцію на екран, відсортовану за назвою бренда :");
            System.out.println("2 - додати новий девайс  :");
            System.out.println("3 - шукати девайс за серійним номером. Якщо не знайдено — викидати помилку, яку створите самостійно. ");
            System.out.println("4 - видалити найдорожчий девайс  :");
            System.out.println("5 - замінити бренд у девайсах. З консолі зчитати який і на який бренд треба замінити: ");
            System.out.println("6 - вивести спиок назв девайсів , які в серійному номері мають цифру 4 і дорожчі за 800   :");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    for (Device device1:devices)System.out.println(device1);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:System.exit(0);
            }
        }
    }
public Device newDevice(){
        Device device = new Device();
    System.out.println("Введіть ІД");
    Scanner scanner = new Scanner(System.in);
    int id = scanner.nextInt();

    System.out.println("Введіть Бренд");
    String name = scanner.nextLine();

    System.out.println("Введіть інформацію");
    String info = scanner.nextLine();

    System.out.println("Введіть ціну");
    int price = scanner.nextInt();
    device.setSerialNumber(id);
    device.setBrand(name);
    device.setInfo(info);
    device.setPrice(price);
    return device;
}

}
