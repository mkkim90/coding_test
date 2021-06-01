package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZeroesTest {
    @Test
    void solution() {
        int[] nums = {0,1,0,3,12};
        assertThat(moveZeroes(nums)).containsExactly(1,3,12,0,0);
    }

    public int[] moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) nums[i++] = num;
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }
}
