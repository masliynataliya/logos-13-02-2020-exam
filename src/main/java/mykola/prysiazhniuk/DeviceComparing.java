package mykola.prysiazhniuk;

import java.util.Comparator;

public class DeviceComparing implements Comparator<Device> {
    @Override
    public int compare(Device o1, Device o2) {
        if (o1.getPrice() > o2.getPrice())
            return 1;
        if (o1.getPrice() < o2.getPrice())
            return -1;
        return 0;
    }
}
