package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6_CompressTest {
    @Test
    void solution() {
        assertThat(compress("aabcccca")).isEqualTo("a2b1c4a1");
    }


    String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        return compressed.toString();
    }
}
