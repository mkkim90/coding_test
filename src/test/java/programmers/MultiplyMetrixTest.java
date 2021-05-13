package programmers;

/**
 * C[i][j] = A[i][1]B[1][j] + A[i][2]B[2][j] + ... + A[i][n]*B[n][j]
 */
public class MultiplyMetrixTest {

    private int[][] multiplyMetrix(int[][] a, int[][] b) {
        int[][] answer = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < b.length; k++) {
                    answer[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return answer;
    }
}
