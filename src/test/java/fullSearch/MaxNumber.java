package fullSearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 */
public class MaxNumber {

    @Test
    void solution() {
        assertThat(maxNumber("1924",2)).isEqualTo("94");
    }

    private String maxNumber(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0') return "0";
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
