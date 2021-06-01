package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 */
public class IntersectionOfTwoLinkedListsTest {
    private ListNode listA;
    private ListNode listB;

    @BeforeEach
    void setUp() {
        listA = new ListNode(1);
        listA.next = new ListNode(9);
        listA.next.next = new ListNode(1);
        listA.next.next.next = new ListNode(2);
        listA.next.next.next.next = new ListNode(4);

        listB = new ListNode(3);
        listB.next = new ListNode(2);
        listB.next.next = new ListNode(4);
    }

    @Test
    void solution() {
        intersection();
    }

    private ListNode intersection() {
        ListNode a = listA;
        ListNode b = listB;
        while (a != b) {
            a = (a == null) ? listB : a.next;
            b = (b == null) ? listA : b.next;
        }

        return a;
    }
}
