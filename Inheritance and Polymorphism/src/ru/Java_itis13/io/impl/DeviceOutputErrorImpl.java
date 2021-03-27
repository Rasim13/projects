package ru.Java_itis13.io.impl;

import ru.Java_itis13.io.base.DeviceOutput;

public class DeviceOutputErrorImpl implements DeviceOutput {
    @Override
    public void printInfo() {
        System.out.println("Реализация выходного потока на основе System.err");
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
