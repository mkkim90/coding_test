package codingInterview.chapt8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 8.3 마술인덱스 : 배열 A[0 ... n-1]에서 A[i] = i 인 인덱스를 마술 인덱스라 정의한다.
 * 정렬된 상태의 배열이 주어졌을 때, 마술 인덱스가 존재한다면 그 값을 찾는 메서드를 작성하라. 배열안에 중복된 값은 없다.
 */
public class Problem3_MagicFastTest {
    @Test
    void solution() {
        int[] nums = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        assertThat(magicFast(nums)).isEqualTo(7);
    }

    private int magicFast(int[] nums) {
        return magicFast(nums, 0, nums.length - 1);
    }

    private int magicFast(int[] nums, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == mid) {
            return mid;
        } else if (nums[mid] > mid) {
            return magicFast(nums, start, mid -1);
        } else {
            return magicFast(nums, mid + 1, end);
        }
    }
}
