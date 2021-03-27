package ru.Java_itis13.io.base;

import java.util.Scanner;

public abstract class AbstractDeviceInputScannerImpl implements DeviceInput {
    private Scanner scanner;

    public AbstractDeviceInputScannerImpl() {
        this.scanner = new Scanner(System.in);
    }

    public String read(){
        return scanner.nextLine();
    }
}
