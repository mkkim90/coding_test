package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDuplicateTest {
    @Test
    void solution() {
        int[] nums = {1,3,4,2,2};
        assertThat(findDuplicate(nums)).isEqualTo(2);
    }


    private int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[Math.abs(nums[i])];

            if (num >= 0) {
                nums[Math.abs(nums[i])] *= -1;
            } else {
                return Math.abs(nums[i]);
            }
        }

        throw new IllegalArgumentException();
    }
}
