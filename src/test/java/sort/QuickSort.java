package sort;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSort {
    @Test
    void solution() {
        int[] arr = {1, 3, 4, 6, 10, 9, 8, 5, 7};
        quickSort(arr, 0, arr.length-1);
        assertThat(arr).containsExactly(1,3,4,5,6,7,8,9,10);
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
