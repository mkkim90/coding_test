package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextNumberTest {
    @Test
    void test() {

        assertThat(nextNumber(73)).isEqualTo(83);
    }

    private int nextNumber(int num) {
        int bitCount = Integer.bitCount(num);
        for(int i = num+1; ;i++) {
            if(bitCount == Integer.bitCount(i)) {
                return i;
            }
        }
    }

    private int bitOneCount(int num) {
        int count =0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) count++;
        }
        return count;
    }
}
