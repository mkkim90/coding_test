package yosa;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    @Test
    void solution() {
        int N = 8;
        int leng = (int) Math.log10(N);
        System.out.println(leng);
        //System.out.println(Math.pow(10, leng));
    }

    @Test
    void solution2() {
        int[] A = {6,2,3,5,6,3};
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int cnt = 0;
                cnt = getCnt(A, map, i);
                map.put(A[i] + cnt, 0);
                answer += cnt;
                continue;
            }
            map.put(A[i], 0);
        }

        assertThat(answer).isEqualTo(4);
    }

    private int getCnt(int[] A, Map<Integer, Integer> map, int i) {
        int cnt = 0;
        while(map.containsKey(A[i] + cnt)) {
            if ((A[i] <= 2)) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return Math.abs(cnt);
    }

    @Test
    void solution3() {
        Version version = new Version("3.8-SNAPSHOT");
        String expected = "3.8.0-SNAPSHOT";
        assertThat(version.getVersion()).isEqualTo(expected);
    }

    @Test
    void solution4() {
        String str = "3.8.9-SNAPSHOT";
        assertThat(str.endsWith("-SNAPSHOT")).isTrue();
    }
}
