package com.manikanta.corejava.threads;

/**
 * Created by Manikanta Tummalapenta on 25 Jan 2020
 */
public class ThreadCreation {

    public static void main(String[] args) {

        // Call start on object directly
        Procedure1 procedure1 = new Procedure1();
        procedure1.start();

        // Create a new Thread and call start
        Procedure2 procedure2 = new Procedure2();
        Thread thread = new Thread(procedure2);
        thread.start();
    }
}

// Extends Thread
class Procedure1 extends Thread {
    @Override
    public void run() {
        System.out.println("This is method 1 to create thread");
    }
}

// Implements Runnable
class Procedure2 implements Runnable {
    @Override
    public void run() {
        System.out.println("This is method 2 to create thread");
    }
}
