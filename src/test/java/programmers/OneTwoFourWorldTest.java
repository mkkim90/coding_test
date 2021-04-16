package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OneTwoFourWorldTest {

    @Test
    void solution() {
        int num = 5;
        assertThat(getOneTwoFour(num)).isEqualTo("12");
    }

    private String getOneTwoFour(int n) {
        String[] strs = {"4", "1", "2"};
        String answer = "";
        while (n > 0) {
            answer = strs[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}
