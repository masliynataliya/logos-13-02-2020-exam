package ihorpayesnky;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Dir { // why Dir?? i just don`t know

    public static StringBuilder readDevice(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        int information = is.read();

        List<Device> devices = new ArrayList<>();

        while (information != -1) {
            char c = (char) information;


            //devices.add(new Device());

            information = is.read();
        }

        is.close();
        return null;
    }

    public static ArrayList<Device> readDevices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("DeviceDetails.txt"));
        input.useDelimiter(", |\n");

        ArrayList<Device> devices = new ArrayList<>();
        while(input.hasNext()) {
            Long serialNumber = Long.valueOf(input.next());
            String brand = input.next();
            String info = input.next();
            int price = Integer.parseInt(input.next().replace("\r", ""));

            devices.add(new Device(serialNumber, brand, info, price));
        }
        return devices;
    }

}
