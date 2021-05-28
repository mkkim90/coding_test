package leetcode;


import java.util.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterCombinationsTest {
    private static final Map<Character, List<Character>> PHONE_KEYBOARD = new HashMap<>();

    static {
        PHONE_KEYBOARD.put('2', Arrays.asList('a', 'b', 'c'));
        PHONE_KEYBOARD.put('3', Arrays.asList('d', 'e', 'f'));
        PHONE_KEYBOARD.put('4', Arrays.asList('g', 'h', 'i'));
        PHONE_KEYBOARD.put('5', Arrays.asList('j', 'k', 'l'));
        PHONE_KEYBOARD.put('6', Arrays.asList('m', 'n', 'o'));
        PHONE_KEYBOARD.put('7', Arrays.asList('p', 'q', 'r', 's'));
        PHONE_KEYBOARD.put('8', Arrays.asList('t', 'u', 'v'));
        PHONE_KEYBOARD.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    @Test
    void solution() {
        assertThat(letterCombinations("23")).containsExactly("ad","ae","af","bd","be","bf","cd","ce","cf");
    }

    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
       dfs(digits, 0, new StringBuilder(), comb);
       return comb;
    }

    private void dfs(String digits, int i, StringBuilder str, List<String> comb) {
        if (i == digits.length()) {
            comb.add(str.toString());
        } else {
            for (char c : PHONE_KEYBOARD.get(digits.charAt(i))) {
                dfs(digits, i + 1, str.append(c), comb);
                str.deleteCharAt(i);
            }
        }
    }


}
