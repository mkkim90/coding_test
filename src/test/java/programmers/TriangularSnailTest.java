package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangularSnailTest {
    @Test
    void solution() {
        assertThat(triagularSnail(4)).containsExactly(1,2,9,3,10,8,4,5,6,7);
    }

    private int[] triagularSnail(int n) {
        int max = (n * (n + 1)) / 2;
        int[][] metrix = new int[n][n];
        int i = 0, j = 0, k = 1;
        metrix[i][j] = k;

        while (k < max) {
            while (i + 1 < n && metrix[i+1][j] == 0) {
                metrix[++i][j] = ++k;
            }

            while (j + 1 < n && metrix[i][j+1] == 0) {
                metrix[i][++j] = ++k;
            }

            while (j - 1 > 0 && i - 1 > 0 && metrix[i-1][j-1] == 0) {
                metrix[--i][--j] = ++k;
            }
        }

        int[] result = new int[max];
        int index = 0;
        for (int l = 0; l < n; l++) {
            for (int m = 0; m <= l; m++) {
                result[index++] = metrix[l][m];
            }
        }
        return result;
    }
}
