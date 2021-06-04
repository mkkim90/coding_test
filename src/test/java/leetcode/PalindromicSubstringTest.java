package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromicSubstringTest {
    private int count;
    @Test
    void solution() {
       String str = "aaa";
       int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += countPalindromic(str, i,i) + countPalindromic(str, i, i+1);
        }
        assertThat(count).isEqualTo(6);
    }



    private int countPalindromic(String str, int start, int end) {
        int count = 0;
        while(start >= 0 && end < str.length()) {
            if (str.charAt(start--) == str.charAt(end++)) count++;
        }
        return count;
    }
}
