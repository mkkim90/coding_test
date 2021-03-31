package codingInterview.chapt8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 8.1 트리플 스텝 : 어떤 아이가 n개의 계단을 오른다. 한번에 1계단 오르기도 하고 2계단이나 3계단을 오르기도 한다.
 * 계단을 오르는 방법이 몇 가지가 있는지 계산하는 메서드를 구현하라.
 * <p>
 * (n-1)번째 계단에서 한 계단 올라가기
 * (n-2)번째 계단에서 두 계단 올라가기
 * (n-3)번째 계단에서 세 계단 올라가기
 * 이 세가지의 경우의 경로를 모두 더하기
 */
public class Problem1_CountWaysTest {
    @DisplayName("트리플 스텝 재귀")
    @Test
    void solution() {
        assertThat(countWays(4)).isEqualTo(7);
    }

    /* 재귀 */
    int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    @DisplayName("메모이제이션을 활용한 트리플 스텝 테스트")
    @Test
    void solution2() {
        int[] memo = new int[4+1];
        Arrays.fill(memo, -1);
        assertThat(countWaysWithMemorization(4, memo)).isEqualTo(7);
    }

    int countWaysWithMemorization(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWaysWithMemorization(n - 1, memo) + countWaysWithMemorization(n - 2, memo) +
                    countWaysWithMemorization(n - 3, memo);

            return memo[n];
        }
    }


}
