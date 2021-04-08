package codingInterview.chapt13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Problem2_finallyTest {

    @DisplayName("finally 호출 사이클")
    @Test
    void call() {
        bar();
    }

    private void bar() {
        System.out.println("start bar");
        String v = foo();
        System.out.println(v);
        System.out.println("end bar");
    }

    private String foo() {
        int x = 0;
        int y = 5;
        try {
            System.out.println("start try");
            int b = x / y;
            System.out.println("end try");
            return "return from try";
        } catch (Exception ex) {
            System.out.println("catch");
            return "return from catch";
        } finally {
            System.out.println("finally");
        }
    }
}
