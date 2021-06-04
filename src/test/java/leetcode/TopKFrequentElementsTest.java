package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TopKFrequentElementsTest {
    @Test
    void solution() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        assertThat(topKFrequentElements(nums, k)).containsExactly(1,2);
    }
    
    private List<Integer> topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
