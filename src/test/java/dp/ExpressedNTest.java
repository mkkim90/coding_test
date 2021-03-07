package dp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 *
 *
 *
 * N	number	return
 * 5	12	4
 * 2	11	3
 */
public class ExpressedNTest {
    @Test
    void solution() {
        assertThat(expressN(5, 12)).isEqualTo(4);
    }
    public int expressN(int N, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

