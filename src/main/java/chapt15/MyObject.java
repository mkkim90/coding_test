package chapt15;

public class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread" + name + ".foo() : starting");
            Thread.sleep(100);
            System.out.println("Thread" + name + ".foo() : ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread" + name + " : interrupted.");
        }
    }

    public synchronized void bar(String name) {
        try {
            System.out.println("Thread" + name + ".bar() : starting");
            Thread.sleep(100);
            System.out.println("Thread" + name + ".bar() : ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread" + name + " : interrupted.");
        }
    }
}
