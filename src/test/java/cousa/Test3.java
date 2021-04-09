package cousa;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * arr	n	result
 * [5, 3, 9, 13]	8	true
 * [5, 3, 9, 13]	7	false
 */
public class Test3 {
    @Test
    void solution() {
    }


    boolean twosum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
