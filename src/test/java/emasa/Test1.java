package emasa;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 매출원가 계산 문제
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"]	[1500, 2400]
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"]	[1800, 2700]
 * ["P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"]	[7100, 10700]
 */
public class Test1 {
    int salesCount = 0;
    int lifoPrice = 0;

    @Test
    void solution() {
        String[] records = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
        assertThat(calculateCostSales(records)).containsExactly(1800, 2700);
    }


    private int[] calculateCostSales(String[] records) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (String record : records) {
            setPurchasePrice(queue, stack, record);
            addSalesCountAndLifoPrice(stack, record);
        }

        int fifoPrice = getFifoPrice(queue, salesCount);
        int[] result = new int[2];
        result[0] = fifoPrice;
        result[1] = lifoPrice;
        return result;
    }

    private void addSalesCountAndLifoPrice(Stack<Integer> stack, String record) {
        if (record.indexOf("S") < 0) {
            return;
        }
        int saleCount = Integer.parseInt(record.split(" ")[2]);
        for (int i = 0; i < saleCount; i++) {
            lifoPrice += stack.pop();
        }
        salesCount += saleCount;
    }

    private void setPurchasePrice(Queue<Integer> queue, Stack<Integer> stack, String record) {
        if (record.indexOf("P") < 0) {
            return;
        }
        int purchasePrice = Integer.parseInt(record.split(" ")[1]);
        int purchaseCount = Integer.parseInt(record.split(" ")[2]);
        for (int i = 0; i < purchaseCount; i++) {
            queue.offer(purchasePrice);
            stack.push(purchasePrice);
        }
    }

    private int getFifoPrice(Queue<Integer> queue, int salesCount) {
        int fifoPrice = 0;
        for (int i = 0; i < salesCount; i++) {
            fifoPrice += queue.poll();
        }
        return fifoPrice;
    }

}
