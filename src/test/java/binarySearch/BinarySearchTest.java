package binarySearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {
    @Test
    void solution() {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 3;
        assertThat(binarySearch(arr, target)).isEqualTo(2);
    }

    int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int result = 0;
        while (left - right <= 0) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                result = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
