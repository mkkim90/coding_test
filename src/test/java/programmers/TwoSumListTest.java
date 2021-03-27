package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 정수 배열 numbers가 주어집니다.
 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에
 * 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * numbers	    result
 * [2,1,3,4,1]	[2,3,4,5,6,7]
 * [5,0,2,7]	[2,5,7,9,12]
 *
 */
public class TwoSumListTest {
    @Test
    void solution() {
        int[] numbers = {2,1,3,4,1};
        assertThat(twoSumList(numbers)).containsExactly(2,3,4,5,6,7);
    }

    public int[] twoSumList(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
