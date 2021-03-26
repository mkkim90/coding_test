package codingInterview.chapt3;

import java.util.Stack;

public class Problem5_StackSortTest {
    void sort(Stack s) {
        Stack r = new Stack();
        while (!s.isEmpty()) {
            int tmp = (int) s.pop();
            while (!r.isEmpty() && (int) r.peek() > tmp) {
                s.push(r.pop());
            }

            r.push(tmp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
