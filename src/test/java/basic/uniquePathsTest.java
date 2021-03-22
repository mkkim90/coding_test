package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class uniquePathsTest {
    @Test
    void solution() {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        assertThat(uniquePaths(obstacleGrid)).isEqualTo(1);

        int[][] obstacleGrid2 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        assertThat(uniquePaths(obstacleGrid2)).isEqualTo(2);

    }

    private int uniquePaths(int[][] obstacleGrid) {
        int[][] d = new int[obstacleGrid.length][obstacleGrid[0].length];
        d[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    d[i][j] = 0;
                    continue;
                }

                if (i > 0) d[i][j] += d[i-1][j];
                if (j > 0) d[i][j] += d[i][j-1];
            }
        }

        return d[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    @Test
    void solution2() {
        int m = 3;
        int n = 2;
        assertThat(uniquePath(m,n)).isEqualTo(3);
    }

    private int uniquePath(int m, int n) {
        int[][] d = new int[m][n];
        
        d[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) d[i][j] += d[i-1][j];
                if (j > 0) d[i][j] += d[i][j-1];
            }
        }

        return d[m-1][n-1];
    }

}
