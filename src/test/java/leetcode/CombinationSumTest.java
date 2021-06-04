package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumTest {
    @Test
    void solution() {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {2,3,6,7};
        int target = 7;
        combinationSum(result, new ArrayList<>(),nums, target, 0);
        System.out.println(result);
    }

    private void combinationSum(List<List<Integer>> result, List<Integer> cur, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            cur.add(nums[i]);
            combinationSum(result, cur, nums, target - nums[i], i);
            cur.remove(cur.size()-1);
        }
    }
}
