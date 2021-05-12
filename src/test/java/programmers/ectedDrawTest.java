package programmers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 첫 번째 라운드에서 4번 참가자는 3번 참가자와 붙게 되고,
 * 7번 참가자는 8번 참가자와 붙게 됩니다.
 * 항상 이긴다고 가정했으므로 4번 참가자는 다음 라운드에서 2번이 되고,
 * 7번 참가자는 4번이 됩니다. 두 번째 라운드에서 2번은 1번과 붙게 되고,
 * 4번은 3번과 붙게 됩니다.
 * 항상 이긴다고 가정했으므로 2번은 다음 라운드에서 1번이 되고,
 * 4번은 2번이 됩니다.
 * 세 번째 라운드에서 1번과 2번으로 두 참가자가 붙게 되므로 3을 return 하면 됩니다.
 * 8      4     2
 * 1번 -> 1번 -> 1번
 * 2번 -> 2번 -> 2번
 * 3번 -> 3번 -> 2번
 * 4번 -> 2번 -> 1번
 * 5번 -> 2번
 */
public class ectedDrawTest {

    @Test
    void ectedDrawTest() {
        assertThat(solution(8, 4, 7)).isEqualTo(3);
    }

    public int solution(int n, int a, int b) {
        int answer = 1;
        int left = 0;
        int right = 0;

        if (a > b) {
            left = b;
            right = a;
        } else {
            left = a;
            right = b;
        }
        return ectedDraw(left, right, answer);

    }

    int ectedDraw(int left, int right, int count) {
        if (left % 2 != 0 && right - left == 1) {
            return count;
        }

        return ectedDraw(caculate(left), caculate(right), ++count);
    }

    private int caculate(int num) {
        return (num + 1) / 2;
    }
}
