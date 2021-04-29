package programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * | 1 | 2 | 3 | 5 |
 *
 * | 5 | 6 | 7 | 8 |
 *
 * | 4 | 3 | 2 | 1 |
 */
public class LandMarkTest {
    @Test
    void eatingTest() {
        int[][] grounds = {{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}};
        assertThat(landMarkCount(grounds)).isEqualTo(20);
    }

    private int landMarkCount(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][1], Math.max(land[i - 1][0], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < land.length; i++) {
            Arrays.sort(land[i]);
        }
        return land[land.length - 1][3];
    }
}