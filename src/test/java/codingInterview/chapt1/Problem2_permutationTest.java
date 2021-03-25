package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2_permutationTest {

    @Test
    void solution() {
        assertThat(permutation("qwer", "werq")).isTrue();
        assertThat(permutation2("qwer", "werq")).isTrue();
    }


    private boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] contents = s.toCharArray();
        Arrays.sort(contents);
        return new String(contents);
    }


    private boolean permutation2(String s, String t) {
        int[] letters = new int[128];
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
