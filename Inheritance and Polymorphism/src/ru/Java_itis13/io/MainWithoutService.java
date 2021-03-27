package ru.Java_itis13.io;

import ru.Java_itis13.io.base.Device;
import ru.Java_itis13.io.impl.DeviceInputWithTimeScannerImpl;
import ru.Java_itis13.io.impl.DeviceOutputErrorImpl;
import ru.Java_itis13.io.impl.DeviceOutputWithTimeImpl;

public class MainWithoutService {
    public static void main(String[] args) {
//        Device input = new DeviceInputWithPrefixScannerImpl("СЧИТАНО С КОНСОЛИ: ");
//        Device output = new DeviceOutputWithTimeImpl();
        Device output = new DeviceOutputErrorImpl();
        Device input = new DeviceInputWithTimeScannerImpl();
        input.printInfo();
        output.printInfo();
        String text = input.read();
        output.print(text);
    }

}
