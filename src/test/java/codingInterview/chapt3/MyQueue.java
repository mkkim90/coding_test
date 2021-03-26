package codingInterview.chapt3;

import java.util.NoSuchElementException;

public class MyQueue {
    private static class QueueNode {
        private int data;
        private QueueNode next;
        public QueueNode(int data) {
            this.data = data;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public void add(int item) {
        QueueNode t = new QueueNode(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public int remove() {
        if (first == null) throw new NoSuchElementException();
        int data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public int peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
