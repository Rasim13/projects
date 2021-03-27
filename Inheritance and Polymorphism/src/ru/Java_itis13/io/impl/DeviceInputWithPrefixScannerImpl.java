package ru.Java_itis13.io.impl;

import ru.Java_itis13.io.base.AbstractDeviceInputScannerImpl;

public class DeviceInputWithPrefixScannerImpl extends AbstractDeviceInputScannerImpl {

    private String prefix;

    public DeviceInputWithPrefixScannerImpl(String prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public String read() {
        return prefix + " " + super.read();
    }

    @Override
    public void print(String text) {

    }

    @Override
    public void printInfo() {
        System.out.println("Реализация входного устройства на основе Scanner");
    }
}
