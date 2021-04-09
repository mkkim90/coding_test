package codingInterview.chapt2;

import leetcode.ListNode;
import org.junit.jupiter.api.Test;

public class Problem4_PartitionTest {
    @Test
    void solution() {
        ListNode n = new ListNode(3);
        ListNode n2= new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(10);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);
        n.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        partition(n, 5);
    }

    ListNode partition(ListNode node, int x) {
        ListNode head = node;
        ListNode tail = node;

        while (node != null) {
            ListNode next = node.getNext();
            if (node.getVal() < x) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }
}
