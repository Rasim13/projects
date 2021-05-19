package ru.itis.printers;

public class PrinterStandardImpl implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
