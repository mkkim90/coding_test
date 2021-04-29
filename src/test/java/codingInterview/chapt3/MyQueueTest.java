package codingInterview.chapt3;

import chapt3.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    void setQueue() {
        queue = new MyQueue<Integer>();
    }

    @Test
    void test() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertThat(queue.remove()).isEqualTo(1);
        assertThat(queue.remove()).isEqualTo(2);
        assertThat(queue.remove()).isEqualTo(3);
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void real() {
        Queue queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertThat(queue.remove()).isEqualTo(1);
        assertThat(queue.remove()).isEqualTo(2);
        assertThat(queue.remove()).isEqualTo(3);
    }
}
