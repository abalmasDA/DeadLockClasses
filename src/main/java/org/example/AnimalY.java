package org.example;

import java.util.concurrent.TimeUnit;

public class AnimalY {

    public synchronized void growl(AnimalX animalX) throws InterruptedException {
        System.out.println("AnimalY is growling");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("AnimalY is calling AnimalX's run");
        animalX.run();
    }


}
