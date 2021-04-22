package programmers;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * scoville	K	return
 * [1, 2, 3, 9, 10, 12]	7	2
 *
 * print(solution([1, 1, 1], 4), 2)
 * print(solution([10, 10, 10, 10, 10], 100), 4)
 * print(solution([1, 2, 3, 9, 10, 12], 7), 2)
 * print(solution([0, 2, 3, 9, 10, 12], 7), 2)
 * print(solution([0, 0, 3, 9, 10, 12], 7), 3)
 * print(solution([0, 0, 0, 0], 7), -1)
 * print(solution([0, 0, 3, 9, 10, 12], 7000), -1)
 * print(solution([0, 0, 3, 9, 10, 12], 0), 0)
 * print(solution([0, 0, 3, 9, 10, 12], 1), 2)
 * print(solution([0, 0], 0), 0)
 * print(solution([0, 0], 1), -1)
 * print(solution([1, 0], 1), 1)
 */
public class ScovilleTest {
    @Test
    void solution() {
        assertThat(scovilleMixedCount(new int[]{1, 2, 3, 9, 10, 12}, 7)).isEqualTo(2);
        assertThat(scovilleMixedCount(new int[]{0, 2, 3, 9, 10, 12}, 7)).isEqualTo(2);
    }

    private int scovilleMixedCount(int[] scovilles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scoville : scovilles) {
            pq.offer(scoville);
        }
        int answer = 0;
        while (!pq.isEmpty() && pq.peek() <= k) {
            if (pq.size() == 1) {
                return -1;
            }
            int result = pq.poll() + (pq.poll() * 2);

            pq.offer(result);
            answer ++;
        }
        return answer;
    }


}
