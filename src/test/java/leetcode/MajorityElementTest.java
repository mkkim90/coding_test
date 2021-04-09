package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 릿코드 169 과반수 원소
 * 과반수 알고리즘
 *
 */
public class MajorityElementTest {

    @Test
    void solution() {
        int[] nums = {3,2,3,3,2,3};
        assertThat(majorityElement(nums)).isEqualTo(3);
    }

    private int majorityElement(int[] nums) {
        int x = 0;
        int cnt = 0;

        for (int num: nums) {
            if (cnt == 0) {
                x = num;
                cnt++;
            } else if (x == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return x;
    }


}
