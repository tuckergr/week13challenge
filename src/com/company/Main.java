package com.company;

import java.sql.Time;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Restroom1 rest1 = new Restroom1();
        Restroom2 rest2 = new Restroom2();
        Restroom3 rest3 = new Restroom3();
        Restroom4 rest4 = new Restroom4();
        Timer time = new Timer();

        Thread t1 = new Thread(rest1);
        Thread t2 = new Thread(rest2);
        Thread t3 = new Thread(rest3);
        Thread t4 = new Thread(rest4);
        Thread t5 = new Thread(time);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



    }
    static int numPpl=20;
    static Semaphore sem = new Semaphore(4,true);
}

class Restroom1 implements Runnable{
     public void run(){
            for (int i = 0; i < Main.numPpl; i++) {
                try { Main.sem.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("Restroom 1 is in use");
                try { Thread.sleep(2250); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("Restroom 1 available");
                Main.sem.release();
                Main.numPpl--;
            }
        }

}

class Restroom2 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.numPpl; i++) {
            try { Main.sem.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 is in use");
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 2 available");
            Main.sem.release();
            Main.numPpl--;
        }
    }
}


class Restroom3 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.numPpl; i++) {
            try { Main.sem.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 3 is in use");
            try { Thread.sleep(500); }catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 3 available");
            Main.sem.release();
            Main.numPpl--;
        }
    }
}

class Restroom4 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.numPpl; i++) {
            try { Main.sem.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 4 is in use");
            try { Thread.sleep(3500); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Restroom 4 available");
            Main.sem.release();
            Main.numPpl--;
        }
    }
}

class Timer implements Runnable{
    public void run(){
        for (int i = 1; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " seconds");
        }
    }
}