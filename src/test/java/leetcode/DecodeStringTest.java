package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * <p>
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class DecodeStringTest {
    @Test
    void solution() {
        assertThat(decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    }

    // "3[a2[c]]"
    int i = 0;

    private String decodeString(String str) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            i++;

            if (c == ']') break;
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String tmp = decodeString(str);
                for (int j = 0; j < count; j++) {
                    sb.append(tmp);
                }
                count = 0;
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
