package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RemoveNthNodeFromEndOfList {
    private ListNode root;

    @BeforeEach
    void setUp() {
        //[1,2,3,4,5]
        root = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        //four.next = five;
        three.next = four;
        two.next = three;
        root.next = two;
    }

    @Test
    void solution() {
      //  removeNthFromEnd(root, 2);
        System.out.println(
            Math.abs(-2147483648 / -1)
        );
    }

    private ListNode removeNthFromEnd(ListNode root, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = root;

        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
