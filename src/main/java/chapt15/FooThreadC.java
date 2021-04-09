package chapt15;

public class FooThreadC extends Thread {
    private Foo foo;

    public FooThreadC(Foo foo) {
        this.foo = foo;
    }

    public void run() {
        foo.third();
    }
}
