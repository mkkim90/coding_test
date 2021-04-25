package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 입출력 예
 * prices	return
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 * 입출력 예 설명
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */
public class StockPriceTest {

    @Test
    void soluttion() {
        int[] prices = {1,2,3,2,3};
        assertThat(increaseStockPricesTimes(prices)).containsExactly(4, 3, 1, 1, 0);
    }

    private int[] increaseStockPricesTimes(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                answer[i]++;
                if (prices[i] <= prices[j]) {
                    continue;
                }
                break;
            }
        }
        return answer;
    }
}
