package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumSubarrayTest {

    @Test
    void solution() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertThat(maxSubArray(nums)).isEqualTo(6);
    }

    int maxSubArray(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            d[i] = Math.max(d[i-1] + nums[i], nums[i]);
        }

        int max = d[0];
        for(int num : d) {
            if (num > max) max = num;
        }
        return max;
    }
}
