package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllNumbersDisappearedInAnArrayTest {
    @Test
    void solution() {
        int[] nums = {4,3,2,7,8,2,3,1};
        assertThat(findDisappearedNumbers2(nums)).containsExactly(5,6);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) s.add(num);
        for (int i = 1; i <= nums.length; i++) {
            if (!s.contains(i)) list.add(i);
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
