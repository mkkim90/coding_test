package leetcode;

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
    @Test
    void solution2() {
        int[] nums = {3,2,1,5,6,4};
        assertThat(findKthLargestByQuick(nums, 2)).isEqualTo(5);
    }


    private int findKthLargestByQuick(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index -1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // 분할 기준 원소 선정
        while (left <= right) {
            // 왼쪽에서 오른쪽으로 옮겨야 하는 원소 탐색
            while (arr[left] < pivot) left++;

            // 오른쪽에서 왼쪽으로 옮겨야 하는 원소 탐색
            while (arr[right] > pivot) right--;

            // 원소를 스왑한 뒤 left와 right를 이동
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
