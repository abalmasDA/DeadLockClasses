package org.example;


import java.util.concurrent.TimeUnit;

public class AnimalX {
    public synchronized void roar(AnimalY animalY) throws InterruptedException {
        System.out.println("AnimalX is roaring");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("AnimalX is calling AnimalY's growl");
        animalY.growl(this);
    }
    public synchronized void run() {
        System.out.println("AnimalX is running");
    }


}
