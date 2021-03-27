package basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 릿코드 784 Letter Case Permutation
 * <p>
 * input : S = "a1b2"
 * output : ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * input : S = "12345"
 * output : ["12345"]
 */
public class LetterCasePermutationTest {

    @Test
    void solution() {
        String str = "a1b2";
        List<String> ret = new ArrayList<>();
        char[] array = str.toCharArray();
        backtrace(array, ret, 0);
    }

    private void backtrace(char[] array, List<String> ret, int i) {
        if (array.length == i) {
            ret.add(new String(array));
            return;
        }
        char c = array[i];
        if (isAlpabet(c)) {
            array[i] = Character.toLowerCase(c);
            backtrace(array, ret, i+1);
            array[i] = Character.toUpperCase(c);
            backtrace(array, ret, i+1);
        } else {
            backtrace(array, ret, i+1);
        }
    }

    private boolean isAlpabet(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
