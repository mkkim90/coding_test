package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1.1 중복이 없는가 : 문자열이 주어졌을 때 문자가 중복되어 등장하는지 확인하는 알고리즘
 */
public class Problem1_isUniqueCharsTest {

    @Test
    void solution() {
        assertThat(isUniqueChars("qwertyq")).isFalse();
    }

    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
