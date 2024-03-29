package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestIncreasingSubsequenceTest {
    @Test
    void solution() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 10};
        assertThat(longestIncreasingSubsequenceWithDP(nums)).isEqualTo(4);
    }

    int longestIncreasingSubsequence(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && d[j] > max) {
                    max = d[j];
                }
            }

            d[i] = max + 1;
        }

        int max = d[0];
        for (int i = 0; i < nums.length; i++) {
            if (d[i] > max) max = d[i];
        }

        return max;
    }

    int longestIncreasingSubsequenceWithDP(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

}
