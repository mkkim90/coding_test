package codingInterview.chapt3;

import java.util.Stack;

/**
 * 3.4 스택으로 큐 : 스택 두 개로 큐 하나를 구현한 MyQueue 클래스를 구현하라.
 */
public class Problem4_MyQueueTest {
    class MyQueue {
        Stack<Integer> stackNewest;
        Stack<Integer> stackOldest;

        public MyQueue() {
            stackNewest = new Stack<>();
            stackOldest = new Stack<>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(int value) {
            stackNewest.push(value);
        }

        public int peek() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
            return stackOldest.peek();
        }

        public int remove() {
            peek();
            return stackOldest.pop();
        }
    }
}
