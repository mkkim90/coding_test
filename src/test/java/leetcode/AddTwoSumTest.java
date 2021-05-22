package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2. Add Two Numbers
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoSumTest {
    private ListNode l1 = new ListNode(2);
    private ListNode l2 = new ListNode(5);

    @BeforeEach
    void setUp() {
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(4);

        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    }

    @Test
    void soluttion() {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }

    }


    private static class ListNode {
        int val;
        AddTwoSumTest.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, AddTwoSumTest.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
