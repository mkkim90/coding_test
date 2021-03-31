package codingInterview.chapt8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    @Test
    void fibonacciTest() {
        assertThat(fibonacci(4)).isEqualTo(3);
        assertThat(fibonacci2(4)).isEqualTo(3);
        assertThat(fibonacci3(4)).isEqualTo(3);
    }


    /* 상향 프로그래밍 */
    private int fibonacci3(int i) {
        if (i == 0 || i == 1) return i;
        int[] memo = new int[i];
        memo[0] = 0;
        memo[1] = 1;
        for (int j = 2; j < i; j++) {
            memo[j] = memo[j-1] + memo[j-2];
        }
        return memo[i-1] + memo[i-2];
    }

    /* 하향 프로그래밍 */
    private int fibonacci2(int n) {
        return fibonacci(n, new int[n+1]);
    }

    int fibonacci(int i, int[] memo) {
        if (i == 0 || i == 1) return i;
        if (memo[i] ==0) {
            memo[i] = fibonacci(i-1, memo) + fibonacci(i-2, memo);
        }
        return memo[i];
    }

    /* 재귀 */
    private int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i-1) + fibonacci(i-2);
    }
}
