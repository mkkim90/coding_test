package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * s	answer
 * "()()"	true
 * "(())()"	true
 * ")()("	false
 * "(()("	false
 */
public class CorrectParenthesesTest {
    @Test
    void solution() {
        assertThat(isCorrect("()()")).isTrue();
        assertThat(isCorrect("(())()")).isTrue();
        assertThat(isCorrect(")()(")).isFalse();
        assertThat(isCorrect("(()(")).isFalse();
    }

    private boolean isCorrect(String str) {
        if (str.length() > 0 && str.length() % 2 != 0) {
            return false;
        }

        char[] strs = str.toCharArray();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
