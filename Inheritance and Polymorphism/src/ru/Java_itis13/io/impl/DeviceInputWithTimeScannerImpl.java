package ru.Java_itis13.io;

import ru.Java_itis13.io.base.AbstractDeviceInputScannerImpl;

import java.time.LocalDateTime;

public class DeviceInputWithTimeScannerImpl extends AbstractDeviceInputScannerImpl {

    public DeviceInputWithTimeScannerImpl() {
        super();
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация входного устройства через Scanner с отслеживанием времени считвывания");

    }

    @Override
    public String read() {
        return super.read() + " - " + LocalDateTime.now();
    }

    @Override
    public void print(String text) {

    }
}
