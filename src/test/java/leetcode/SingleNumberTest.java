package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleNumberTest {
    // XOR
    // 1. a a b b c d 전부다 XOR = c^d
    // 2. c^d는 적어도 한비트는 1
    // 3. 그 1비트 자리에서 c : 0 d : 1 혹은 c : 1 d : 0
    // 4. 각 그룹마다 유일하게 등장하는 원소는 하나!
    @Test
    void solution() {
        int[] nums = {1,1,2,2,3,5};
        int xor = 0;
        for (int num : nums) xor ^= num;

        int idx = 0;
        for (int i = 0; i < 32; i++) {
            if ((((xor >> i) & 1) == 1)) {
                idx = i;
                break;
            }
        }

        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums) {
            if ((((num >> idx) & 1) == 1)) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }

        int[] ret = {xor1, xor2};
        Arrays.sort(ret);
        assertThat(ret).contains(3,5);
    }
}
