package util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHashSetTest {

    @Test
    void solution() {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(5);
        assertThat(set.size()).isEqualTo(4);

    }
}
