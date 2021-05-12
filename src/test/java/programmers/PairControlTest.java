package programmers;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * b aa baa → bb aa → aa →
 */
public class PairControlTest {
    @Test
    void solution() {
        assertThat(findFirstPairIndex("baabaa")).isEqualTo(1);
        assertThat(findFirstPairIndex("bcdbaa")).isEqualTo(4);
        assertThat(pairControl("baabaa")).isEqualTo(1);
        assertThat(pairControl("cdcd")).isEqualTo(0);
    }

    int pairControl(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        return stack.isEmpty() ? 1 : 0;
    }

    int findFirstPairIndex(String str) {
        char[] strs = str.toCharArray();
        char pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char current = strs[i];
            if ( pre == current) {
                return i - 1;
            }

            pre = current;
        }

        return -1;
    }
}
