package ru.Java_itis13.io;

import ru.Java_itis13.io.base.DeviceInput;
import ru.Java_itis13.io.base.DeviceOutput;

//паттерн фасад - обернуть функциональность нескольких разных классов в один класс
public class IOService {

    private DeviceInput input;
    private DeviceOutput output;

    public IOService(DeviceInput input, DeviceOutput output) {
        this.input = input;
        this.output = output;
    }

    void print(String message){
        output.print(message);

    }

    String read(){
        return  input.read();
    }

    void printDevicesInformation(){
        input.printInfo();
        output.printInfo();
    }
}
