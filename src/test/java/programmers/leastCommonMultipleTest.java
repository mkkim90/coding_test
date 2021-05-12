package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 * 최소공배수 구하기
 * 소인수분해로 배열을 추출하기
 * 소인수분해 갯수의 최대값을 넣는다
 * 그리고 풀어내서 곱합다.
 */
public class leastCommonMultipleTest {
    @Test
    void 소인수분해로_추출하기() {
        Map<Integer, Integer> map = factorizationPrimeFactor(6);
        assertThat(map.containsKey(2)).isTrue();
        assertThat(map.containsKey(3)).isTrue();
    }

    private Map<Integer, Integer> factorizationPrimeFactor(int number) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 2; i <= Math.sqrt(number); i++) {    // 또는 i * i <= N
            while (number % i == 0) {
                result.put(i, result.getOrDefault(i, 0) + 1);
                number /= i;
            }
        }

        if (number != 1) {
            result.put(number, result.getOrDefault(number, 0) + 1);
        }
        return result;
    }

    @Test
    void 소인수분해_갯수의_최대값을_넣는다() {
        int[] nums = {2,6,8,14};
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            Map<Integer, Integer> map = factorizationPrimeFactor(num);
            for (int key : map.keySet()) {
                if (!result.containsKey(key) || result.containsKey(key) && result.get(key) < map.get(key)) {
                    result.put(key, map.get(key));
                }
            }
        }
        int answer = 1;
        for (int key : result.keySet()) {
            answer *= Math.pow(key, result.get(key));
        }

        assertThat(answer).isEqualTo(168);
    }

}
