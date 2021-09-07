package ru.itis;

import ru.itis.Example1.EggVoice;
import ru.itis.Example2.ThreadByRunnable;

public class Main {

    static EggVoice mAnotherOpinion;

    public static void main(String[] args) {
//
//        for (int i = 0; i < 10; i++) {
//            FirstThread thread = new FirstThread();
//            thread.start();
//        }

//        mAnotherOpinion = new EggVoice();
//        System.out.println("Спор начат....");
//
//        mAnotherOpinion.start();
//
//        for (int i = 0; i < 5; i++) {
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//
//            }
//
//            System.out.println("Курица");
//        }
//
//        if (mAnotherOpinion.isAlive()) {
//
//            try {
//                mAnotherOpinion.join();
//            } catch (InterruptedException e) {
//
//            }
//            System.out.println("Первым появился яйцо!");
//        } else {
//            System.out.println("Первой появилась курица!");
//        }
//
//        System.out.println("Спор закончен!");

        ThreadByRunnable threadOne = new ThreadByRunnable("ThreadOne");
        ThreadByRunnable threadTwo = new ThreadByRunnable("ThreadTwo");

        threadOne.start();
        threadTwo.start();
    }
}
