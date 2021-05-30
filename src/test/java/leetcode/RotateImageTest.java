package leetcode;

import org.junit.jupiter.api.Test;

public class RotateImageTest {
    @Test
    void solution() {
        //int[][] metrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] metrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(metrix);
    }

    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
