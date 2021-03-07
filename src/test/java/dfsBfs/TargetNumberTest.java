package dfsBfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 */
public class TargetNumberTest {

    @Test
    void solution() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int answer = dfs(numbers, 0, 0, target);
        assertThat(answer).isEqualTo(5);
    }

    private int dfs(int[] numbers, int i, int sum, int target) {
        if (i == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, i + 1, sum + numbers[i], target) + dfs(numbers, i + 1, sum - numbers[i], target);

    }
}
