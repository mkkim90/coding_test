package codingInterview.chapt2;

import basic.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2.2 뒤에서 k번째 원소 구하기 : 단방향 연결리스트가 주어졌을 때 뒤에서 k번째 원소를 찾는 알고리즘
 *
 */
public class Problem2_nthToLastTest {
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
        assertThat(nthToLast(n, 2).getVal()).isEqualTo(2);
    }

    ListNode nthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        /**
         * p1을 k노드만큼 이동시킨다.
         */
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.getNext();
        }
        /**
         * p1과 p2를 함께 움직인다. p1에 끝에 도달하면, p2는 LENGTH-k번째 원소를 가리킨다.
         */
        while(p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p2;
    }
}
