package codingInterview.chapt15;

import chapt15.Foo;
import chapt15.FooThreadA;
import chapt15.FooThreadB;
import chapt15.FooThreadC;

public class FooTest {

    /*Foo 인스턴스 하나를 서로 다른 세 스레드에 전달한다. threadA는 first , threadB는 second, threadC는 third")*/
    public static void main(String[] args) {
        Foo foo = new Foo();
        FooThreadA threadA = new FooThreadA(foo);
        FooThreadB threadB = new FooThreadB(foo);
        FooThreadC threadC = new FooThreadC(foo);
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
