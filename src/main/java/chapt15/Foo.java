package chapt15;

import java.util.concurrent.Semaphore;

public class Foo {
    public Semaphore sem1, sem2;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);

            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        System.out.println("first call");
        sem1.release();
    }

    public void second() {
        try {
            sem1.acquire();
            sem1.release();
            System.out.println("second call");

            sem2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            sem2.release();

            System.out.println("third call");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
