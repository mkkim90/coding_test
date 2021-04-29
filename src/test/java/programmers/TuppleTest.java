package programmers;

import javafx.print.Collation;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TuppleTest {
    @Test
    void replaceTest() {
        String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        assertThat(tupples(str)).containsExactly(3,2,4,1);
    }

    private int[] tupples(String str) {
        String[] tupples = str.substring(2, str.length() - 2).split("\\},\\{");
        Arrays.sort(tupples, (a, b)-> a.length() -b.length());
        Set<Integer> set = new LinkedHashSet<>();
        for (String s : tupples) {
            for (String i : s.split(",")) {
                set.add(Integer.parseInt(i));
            }
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int idx = 0;
        while (it.hasNext()) {
            answer[idx++] = it.next();
        }
        return answer;
    }
}
