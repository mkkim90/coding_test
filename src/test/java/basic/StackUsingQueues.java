package basic;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class StackUsingQueues {

    @Test
    void solution() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertThat(myStack.pop()).isEqualTo(4);
    }

    class MyStack {

        /**
         * 큐 : FIFO
         * 스택 : LIFO
         * 1 2 3 4 5
         */
        Queue<Integer> q = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            int size = q.size();
            q.offer(x);
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
