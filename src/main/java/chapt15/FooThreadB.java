package chapt15;

public class FooThreadB extends Thread {
    private Foo foo;

    public FooThreadB(Foo foo) {
        this.foo = foo;
    }

    public void run() {
        foo.second();
    }

}
