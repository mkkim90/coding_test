package codingInterview.chapt2;

import leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * 중복 제거 2.1 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라.
 *
 */
public class Problem1_deleteDupsTest {
    @Test
    void solution() {
        ListNode n = new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        deleteDups(n);
    }

    void deleteDups(ListNode n ) {
        HashSet set = new HashSet();
        ListNode previous = null;
        while (n != null) {
            if (set.contains(n.getVal())) {
                previous.setNext(n.getNext());
            } else {
                set.add(n.getVal());
                previous = n;
            }
            n = n.getNext();
        }
    }
}
