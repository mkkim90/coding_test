package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 릿코드 64 Minimum Path Sum
 *
 * grid
 * 1, 3, 1
 * 1, 5, 1
 * 4, 2, 1
 *
 * 최소 경로 합
 * 1, 4, 5
 * 2, 7, 6
 * 6, 8, 7
 *
 */
public class MininumPathSumTest {

    @Test
    void solution() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        assertThat(minimumPathSum(grid)).isEqualTo(7);
     }

    private int minimumPathSum(int[][] grid) {
        int[][] d = new int[grid.length][grid[0].length];
        d[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? d[i-1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? d[i][j-1] : Integer.MAX_VALUE;

                d[i][j] = Math.min(left, up) + grid[i][j];
            }
        }

        return d[grid.length-1][grid[0].length-1];
    }
}
