package nsa;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    @Test
    void solution() {
        String T = "SMS";
        LinkedList<Character> list = new LinkedList<>();
        StringBuffer m = new StringBuffer();
        for (char size : T.toCharArray()) {
            if (size == 'M') {
                if (list.contains('S')) list.add(list.lastIndexOf('S') + 1, 'M');
                else if (list.contains('L')) list.add((list.indexOf('L') == 0 ) ? 0: list.indexOf('L') -1, 'M');
                else list.add('M');
            }
            if (size == 'S') list.addFirst(size);
            if (size == 'L') list.addLast(size);
        }

        StringBuffer sb = new StringBuffer();
        for (char c : list) sb.append(c);
    }
}
