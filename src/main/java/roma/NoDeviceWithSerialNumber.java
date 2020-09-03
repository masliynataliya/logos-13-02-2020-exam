package roma;

public class NoDeviceWithSerialNumber extends RuntimeException {
    NoDeviceWithSerialNumber(){
        System.out.println("Не знайдено такого девайса");
    }
}
