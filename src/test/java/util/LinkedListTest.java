package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {
    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void addTest() {
        list.add(4);
        list.addAll(Arrays.asList(1,2,3));
        list.add(3, 5);
        assertThat(list.size()).isEqualTo(8);
    }

    @Test
    void removeTest() {
        list.remove(2);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void getTest() {
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    void indexOf() {
        assertThat(list.indexOf(2)).isEqualTo(1);
    }

}
