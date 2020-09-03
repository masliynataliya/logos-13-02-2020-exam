package mykola.prysiazhniuk;


import java.util.*;

public class ExamApplication  {


    public static void main(String[] args) {
        ArrayList<Device> list = new ArrayList<>();
        list.add(new Device(9842520351l, "Apple", "iPhone 11 Max pro", 1182));
        list.add(new Device(9939741187l, "Samsung", "Microwave oven 230M", 369));
        list.add(new Device(8649874542l, "Samsung", "Galaxy note 333", 350));
        list.add(new Device(9272368081l, "LG", ", Smart TV N140", 659));
        list.add(new Device(9493736531l, "LG", "CoffeeMaker CBVNG-11256", 410));
        list.add(new Device(8998039568l, "Samsung", "Fitnes Tracker S3", 374));
        list.add(new Device(8761722774l, " Apple", "AirPods", 931));
        list.add(new Device(8689595242l, "Apple", "Apple - Air in a bottle", 1060));
        list.add(new Device(9916427442l, "LG", "PowerBank 40 000 mAh", 857));
        list.add(new Device(9236910372l, "Apple", "MacBook Pro 2020", 1500));


            while(true) {
                System.out.println("1 - Вивести всю колекцію на екран");
                System.out.println("2 - Додати новий девайс");
                System.out.println("3 - Шукати девайс за серійним номером");
                System.out.println("4 - Видалити найдорожчий девайс");
                System.out.println("5 - Замінити бренд у  девайсах");
                System.out.println("6 - вивести спиок назв девайсів (тільки назв), які в серійному номері мають цифру 4 і дорожчі за 800");
                System.out.println("7 - вихід ");
                System.out.println();

                System.out.println("Виберіть варіант");
                Scanner sc = new Scanner(System.in);
                String option = sc.next();

                switch (option) {
                    case "1":
                        System.out.println("Вивести всю колекцію на екран");
                        System.out.println(list);
                        System.out.println();

                        break;
                    case "2":
                        System.out.println("Додати новий девайс");
                        System.out.println("Введіть серійний номер");
                        long serialNumber = sc.nextLong();
                        System.out.println("Введіть бренд девайсу");
                        String brand = sc.next();
                        System.out.println("Введіть модель девайсу");
                        String info = sc.next();
                        System.out.println("Введіть ціну девайсу");
                        int price = sc.nextInt();
                        Device device = new Device(serialNumber, brand, info, price);
                        list.add(device);

                        break;
                    case "3":
                        System.out.println("Шукати девайс за серійним номером");

                        break;
                    case "4":
                        System.out.println("Видалити найдорожчий девайс");

                        break;
                        }

                        }
                    }


                }

















