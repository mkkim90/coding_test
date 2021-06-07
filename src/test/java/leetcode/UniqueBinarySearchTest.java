package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueBinarySearchTest {
    @Test
    void solution() {
        assertThat(numTrees(3)).isEqualTo(5);
    }
    
    private int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j-1] * dp[i-j] + dp[i];
            }
        }

        return dp[n];
    }
    
}
