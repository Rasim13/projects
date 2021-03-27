package ru.Java_itis13.io;

import ru.Java_itis13.io.base.DeviceOutput;

import java.time.LocalDateTime;

public class DeviceOutputWithTimeImpl implements DeviceOutput {
    @Override
    public void print(String message) {
        System.out.println("Сообщение в " + LocalDateTime.now() + " [ " + message + " ] ");
    }

    @Override
    public void printInfo() {
        System.out.println("Реализация выходного устройства со временем.");

    }

    @Override
    public String read() {
        return null;
    }
}
