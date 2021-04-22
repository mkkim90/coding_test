package programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [70, 50, 80, 50]	100	3
 * [70, 80, 50]	100	3
 */
public class LifeBoatTest {

    @Test
    void solution() {
        int[] people = {70, 80, 50};
        int limit = 100;
        assertThat(countLifeBoat(people, limit)).isEqualTo(3);
    }

    private int countLifeBoat(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        Arrays.sort(people);
        for (int j = people.length - 1; i <= j; j--) {
            answer++;
            if (people[j] + people[i] <= limit) {
                i++;
            }
        }
        return answer;
    }
}
