package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfArrayExceptSelfTest {
    @Test
    void solution() {
        int[] nums = {1,2,3,4};
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }

        for (int i = nums.length-1, temp = 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        assertThat(result).containsExactly(24,12,8,6);
    }

}
