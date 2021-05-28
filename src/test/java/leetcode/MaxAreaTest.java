package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxAreaTest {
    @Test
    void solution() {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        assertThat(maxArea(nums)).isEqualTo(49);
    }

    private int maxArea(int[] nums) {
        int max = 0;
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            max = Math.max(max, Math.min(nums[right], nums[left])*(right-left));
            if (nums[right] > nums[left]) left++;
            else right--;
        }
        return max;
    }
}
