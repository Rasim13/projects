package ru.itis.Example1;

public class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("Выполнен поток " + getName());
    }
}
