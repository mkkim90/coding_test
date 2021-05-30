package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInRotatedSortedArrayTest {
    @Test
    void solution() {
        int[] nums = {0, 1, 2, 4, 5, 6, 7};
        assertThat(search(nums, 7)).isEqualTo(6);

    }

    private int search(int[] nums, int target) {
        Stack<Integer> stack = new Stack<>();
        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && stack.peek() > nums[i]) {
                pivot = i;
                break;
            }
            stack.push(nums[i]);
        }

        if (pivot != 0) {
            int firstSearch = search(nums, 0, pivot - 1, target);
            if (firstSearch != -1) return firstSearch;
        }

        int secondSearch = search(nums, pivot, nums.length - 1, target);
        if (secondSearch != -1) return secondSearch;

        return -1;
    }

    private int search(int[] nums, int start, int end, int target) {
        int l = start;
        int h = end;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
