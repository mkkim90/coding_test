package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueUsingStack {
    @Test
    void solution() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        assertThat(q.pop()).isEqualTo(1);
    }

    class MyQueue {
        // 스택 : LIFO +LIFO -> FIFO
        // 큐 : FIFO
        /*
        5 1
        4 2
        3 3
        2 4
        1 5
        */
        // 안에서 들어가서 아웃으로 나온다.
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public MyQueue() {
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return out.peek();
        }

        public boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

}
