package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSetsTest {
    private List<List<Integer>> result = new ArrayList<>();

    @Test
    void solution() {
        int[] arr = {1, 2, 3};
        result.add(new ArrayList<>());
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            combination(arr, visited, 0, i);
        }
    }

    private void combination(int[] arr, boolean[] visited, int start, int limit) {
        if (limit == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) list.add(arr[i]);
            }
            result.add(list);
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, start + 1, limit - 1);
            visited[i] = false;
        }
    }

    @Test
    void backtrackTest() {
        List<List<Integer>> list = new ArrayList<>();
        int[] nums = {1,2,3};
        backtrack(list, new ArrayList<>(), nums, 0);

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
