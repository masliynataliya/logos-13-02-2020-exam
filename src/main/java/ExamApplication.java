import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ExamApplication {
    public static void main(String[] args) throws IOException, MyPersonalExeption {

        List<Device> devices = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("DeviceDetails.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String stringLine;
        while ((stringLine = bufferedReader.readLine()) != null) {
            String device = stringLine;
            device = device.replace(" ", "");
            String[] element = device.split(",");
            devices.add(new Device(Long.parseLong(element[0]), element[1], element[2], Integer.parseInt(element[3])));
        }

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("Виберіть наступний пунк:\n" +
                    "1 - вивести всю колекцію на екран (кожен девайс - з нової стрічки), відсортовану за назвою бренда\n" +
                    "2 - додати новий девайс (всі поля вводити з консолі)\n" +
                    "3 - шукати девайс за серійним номером. Якщо не знайдено — викидати помилку, яку створите самостійно.\n" +
                    "4 - видалити найдорожчий девайс (якщо кілька девайсів мають однакову найбільшу ціну - видалити всі)\n" +
                    "5 - замінити бренд у девайсах. З консолі зчитати який і на який бренд треба замінити\n" +
                    "(наприклад, бренд змінив назву з LG на GoldStar — треба відповідно оновити всі об’єкти)\n" +
                    "6 - вивести спиок назв девайсів (тільки назв), які в серійному номері мають цифру 4 і дорожчі за 800.");

            switch (scanner.nextInt()){
                case 1 :
                    devices.stream().sorted(Comparator.comparing(Device::getBrand)).forEach(System.out::println);
                    break;

                case 2 :
                    Device device = new Device();
                    System.out.println("Введіть серійний номер.");
                    device.setSerialNumber(scanner.nextLong());
                    System.out.println("Введіть назву бренда.");
                    device.setBrand(scanner.next());
                    System.out.println("Введіть інформацію.");
                    device.setInfo(scanner.next());
                    System.out.println("Введіть ціну.");
                    device.setPrice(scanner.nextInt());
                    devices.add(device);

                    break;

                case 3:
                    System.out.println("Введіть серійний номер девайса який бажаєте знайти.");
                    long serNum = scanner.nextLong();
                    int i = 0;
                    for (Device d: devices) {
                        if (d.getSerialNumber() == serNum) {
                            System.out.println(d.toString());
                            i++;
                        }
                    }
                    if (i == 0){
                        throw new MyPersonalExeption("My personal Exeption");
                    }
                    break;

                case 4:
                    int localPrice = 0;
                    for (Device d: devices) {
                        if (d.getPrice() >= localPrice){
                            localPrice = d.getPrice();
                        }
                    }
                    int finalLocalPrice = localPrice;
                    devices.removeIf(d -> d.getPrice() == finalLocalPrice);

                    break;

                case 5:
                    System.out.println("Введіть назву бренду який необхідно замінити");
                    String oldName = scanner.next();
                    System.out.println("Введіть нову назву бренду");
                    String newName = scanner.next();
                    devices.stream()
                            .filter(d -> d.getBrand().equalsIgnoreCase(oldName))
                            .forEach(device1 -> device1.setBrand(newName));
                    break;

                case 6 :
                    devices.stream().
                            filter(d -> serNumberControl(d.getSerialNumber()) & d.getPrice() >= 800)
                            .forEach(device1 -> System.out.println(device1.getInfo()));


                    break;
            }

        }
    }

    private static boolean serNumberControl(long serialNumber) {
        String serNum = String.valueOf(serialNumber);
        return serNum.contains("4");
    }
}
