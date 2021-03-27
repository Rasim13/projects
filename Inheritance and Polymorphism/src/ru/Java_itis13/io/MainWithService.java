package ru.Java_itis13.io;

import ru.Java_itis13.io.impl.DeviceInputWithTimeScannerImpl;
import ru.Java_itis13.io.impl.DeviceOutputWithTimeImpl;

public class MainWithService {
    public static void main(String[] args) {
        IOService service = new IOService(
                new DeviceInputWithTimeScannerImpl(),
                new DeviceOutputWithTimeImpl());

        service.printDevicesInformation();
        String message = service.read();
        service.print(message);
    }
}
