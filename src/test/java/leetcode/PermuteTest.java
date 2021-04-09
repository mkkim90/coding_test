package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 순열 백트랙킹
 * <p>
 * 임시 배열에 숫자가 포함되어 있으면 스킵하고 아닌 경우에는 넣는다
 * 그리고 재귀로 백트랙킹 함수를 호출
 * nums 배열 길이가 같을 경우, 결과 배열값에 다 넣구 리턴
 * 그리고 임시 배열 마지막 값을 지운다.
 */
public class PermuteTest {
    @Test
    void solution() {
        int[] nums = {1, 2, 3};
        permute(nums);
    }

    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, ret, tmp);
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            backtrack(nums, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
