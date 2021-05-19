package ru.itis.printers;

public class PrinterErrorImpl implements Printer {

    private String prefix;

    @Override
    public void print(String message) {
        System.err.println(prefix + " " + message);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
