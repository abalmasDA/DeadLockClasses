package org.example;

/**
 * Створити 2 класи. Реалізувати взаємне блокування цих класів
 */


/**
 * Коментарі до коду:
 *1) Потік thread1 викликає метод animalX.roar(animalY), далі захоплює блокування на об'єкті animalX (адже виконується метод roar()), а потім засинає на 3 секунди.
 * 2) Потік thread2 викликає метод animalY.growl(animalX) та намагається захопити блокування на об'єкті animalY, та воно вже захоплено thread1 (адже animalX.roar(animalY) виконується у thread1), тому thread2 блокується і чекає поки блокування на об'єкті animalY буде звільнено.
 * 3) Таким чином обидва потоки thread1 та thread2 в стані очікування, а саме thread1 очікує звільнення блокування на animalY, а thread2 очікує звільнення блокування на animalX.
 */
public class Main {
    public static void main(String[] args) {
        final AnimalX animalX = new AnimalX();
        final AnimalY animalY = new AnimalY();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    animalX.roar(animalY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    animalY.growl(animalX);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
