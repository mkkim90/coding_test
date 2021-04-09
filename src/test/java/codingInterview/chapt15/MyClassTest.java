package codingInterview.chapt15;

import chapt15.MyClass;
import chapt15.MyObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyClassTest {

    @DisplayName("서로 다른 객체인 경우 동시에 MyObject.foo() 호출이 가능하다")
    @Test
    void callFooByAnotherObject() {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        /* 서로 다른 객체인 경우 동시에 MyObject.foo() 호출이 가능하다 */
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");
        thread1.start();
        thread2.start();

        /* 같은 obj를 가리키고 있는 경우에는 하나만 foo를 호출할 수 있고 다른 하나는 기다리고 있어야한다 */
        MyClass thread3 = new MyClass(obj1, "1");
        MyClass thread4 = new MyClass(obj1, "1");
        thread3.start();
        thread4.start();

        /* 설사 하나는 foo를 호출하고 있고 다른 하나는 bar를 호출하여도 기다리고 있어야한다.*/
        MyClass thread5 = new MyClass(obj1, "1");
        MyClass thread6 = new MyClass(obj1, "4");
        thread5.start();
        thread6.start();
    }

}
