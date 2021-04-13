package emasa;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"]	[1500, 2400]
 * ["P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"]	[1800, 2700]
 * ["P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"]	[7100, 10700]
 */
public class Test1 {
    Queue<Integer> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    int salesCount = 0;

    @Test
    void solution() {
        String[] records = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
        assertThat(process(records)).containsExactly(1800, 2700);
    }

    private int[] process(String[] records) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int salesCount = 0;

        int lifoPrice = 0;
        for (String record : records) {
            if (record.indexOf("P") > -1) {
                int purchasePrice = Integer.parseInt(record.split(" ")[1]);
                int purchaseCount = Integer.parseInt(record.split(" ")[2]);
                for (int i = 0; i < purchaseCount; i++) {
                    queue.offer(purchasePrice);
                    stack.push(purchasePrice);
                }
            }
            if (record.indexOf("S") > -1) {
                int saleCount = Integer.parseInt(record.split(" ")[2]);
                for (int i = 0; i < saleCount; i++) {
                    if (!stack.isEmpty()) {
                        lifoPrice += stack.pop();
                    }
                }
                salesCount += saleCount;

            }
        }

        int fifoPrice = 0;
        for (int i = 0; i < salesCount; i++) {
            fifoPrice += queue.poll();
        }

        int[] result = new int[2];
        result[0] = fifoPrice;
        result[1] = lifoPrice;
        return result;
    }
}
