package codingInterview.chapt2;

import basic.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6_isPalindromeTest {

    @Test
    void solution() {
        ListNode n = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(0);
        n4.setNext(n5);
        n3.setNext(n4);
        n2.setNext(n3);
        n.setNext(n2);

        assertThat(isPalindrome(n)).isTrue();
    }

    boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getVal());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.getVal()) {
                return false;
            }
            slow = slow.getNext();
        }

        return true;
    }
}
