package chapt15;

public class FooThreadA extends Thread {
    private Foo foo;

    public FooThreadA(Foo foo) {
        this.foo = foo;
    }

    public void run() {
        foo.first();
    }

}
