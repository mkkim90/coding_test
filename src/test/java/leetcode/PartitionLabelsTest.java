package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartitionLabelsTest {
    @Test
    void solution() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = new ArrayList<>();
        dfs(s, list);
        assertThat(list).containsExactly(9, 8, 7);
    }

    private void dfs(String s, List<Integer> list) {
        if (s.length() == 0) return;

        int last = s.lastIndexOf(s.charAt(0));
        for (int i = 0; i < last; i++) {
            if (s.lastIndexOf(s.charAt(i)) <= last) continue;
            last = s.lastIndexOf(s.charAt(i));
        }

        s = s.substring(last+1);
        list.add(last + 1);
        dfs(s, list);
    }
}
