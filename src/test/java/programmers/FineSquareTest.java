package programmers;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class FineSquareTest {
    int count = 0;
    @Test
    void solution() {
        assertThat(fineSquareCount3(8, 12)).isEqualTo(80);
    }
    
    private void fineSquareCount(int width, int height, int index) {
        if (width < 1 || height < 1) {
            return;
        }
        count += ((int) width / 2) * ((int) height / 2) * (2 * index);
        fineSquareCount(width / 2 , height / 2, index * 2);
    }

    private int fineSquareCount2(int width, int height) {
        int answer = 0;
        for (int i = 0; i < width; i++) {
            answer += height * i / width;
        }

        return answer * 2;
    }

    private int fineSquareCount3(int width, int height) {
        int gcd = BigInteger.valueOf(width).gcd(BigInteger.valueOf(height)).intValue();
        return (width * height) - (width + height - gcd);
    }
}
