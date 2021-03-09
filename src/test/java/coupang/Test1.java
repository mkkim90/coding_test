package coupang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * N개의 원소를 가진 수열 A가 있습니다.
 * 수열의 i 번째 수부터 j 번째 수까지의 합이 S가 되도록 하는 (i, j) 쌍의 개수를 구하려고 합니다(단, i ≤ j ).
 * 1차원 배열 형태의 수열 A와 자연수 S가 매개변수로 주어질 때, 가능한 (i, j) 쌍의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 입출력 예
 * A	S	result
 * [1,1,1,1]	3	2
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 첫 번째 수부터 세 번째 수까지의 합이 3입니다.
 * 두 번째 수부터 네 번째 수까지의 합이 3입니다.
 *
 */
public class Test1 {
    int answer;

    @Test
    void solution() {
        int[] A = {1,1,1,1};
        int S = 3;
        assertThat(sequence(A, S)).isEqualTo(2);
    }

    public int sequence(int[] arr, int sum) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = sum;
            for (int j = i; j < arr.length; j++) {
                cur -= arr[j];
                if (cur == 0) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
