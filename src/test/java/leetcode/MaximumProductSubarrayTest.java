package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 릿코드 152 Maximum Product SubArray
 */
public class MaximumProductSubarrayTest {
    @Test
    void solution() {
        int[] nums1 = {2, 3, -2, 4};
        assertThat(maximumProductSubArray(nums1)).isEqualTo(6);

        int[] nums2 = {-2, 0, -1};
    }

    private int maximumProductSubArray(int[] nums) {
        // d[i][0] -> + 0~i max product
        // d[i][1] -> - 0~i min product

        int[][] d = new int[nums.length][2];
        d[0][0] = nums[0];
        d[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int c = nums[i];
            d[i][0] = Math.max(c, Math.max(c*d[i-1][0], c* d[i-1][1]));
            d[i][1] = Math.min(c, Math.min(c*d[i-1][0], c* d[i-1][1]));
        }

        int max = d[0][0];
        for (int i = 0; i < nums.length; i++) {
            if (d[i][0] > max) max = d[i][0];
        }
        return max;
    }
}
