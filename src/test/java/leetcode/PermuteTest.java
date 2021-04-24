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

    @Test
    void dfs() {
        int[] nums = {1, 2, 3};
        int[] output = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        dfs(nums, output, visited, 0, nums.length, 3);
    }

    private void dfs(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
                ;
            }
        }
    }

    private void print(int[] output, int r) {
        for (int i = 0; i < r; i++) {
            System.out.println(output[i]);
        }
        System.out.println("");
    }

    @Test
    private void dfsSwapTest() {
        int[] nums = {1, 2, 3};
        int[] output = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        dfsSwap(nums,0, nums.length, 3);
    }

    void dfsSwap(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            dfsSwap(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
