package basic;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class KthLargestElementInAnArrayTest {
    @Test
    void solution() {
        int[] nums = {3,2,1,5,6,4};
        assertThat(findKthLargest(nums, 2)).isEqualTo(5);
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,
                (a,b) -> a - b);

        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        return pq.peek();
    }
}
