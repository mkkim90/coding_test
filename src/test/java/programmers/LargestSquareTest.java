package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * max를 가지고 있는다
 * 1,1부터 시작한다.
 * 값 1인 경우에만 성립을 하며,
 *
 *
 */
public class LargestSquareTest {

    @Test
    void solution() {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        assertThat(largestSquare(board)).isEqualTo(9);
    }

    private int largestSquare(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (max == 0 ) max++;

                    dp[i][j] = 1;
                    if (i > 0 && j > 0 ) {
                        int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                        dp[i][j] = Math.max(dp[i][j], min);
                        max = Math.max(dp[i][j], max);
                    }
                }

            }
        }

        return max * max;
    }
}
