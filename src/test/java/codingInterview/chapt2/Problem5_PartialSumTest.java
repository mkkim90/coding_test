package codingInterview.chapt2;

import basic.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 2.5 리스트의 합 : 연결리스트로 숫자를 표현할 때 각 노드가 자릿수 하나를 가리키는 방식으로 표현할 수 있다.
 * 각 숫자는 역순으로 배열되어 있는데, 즉, 첫번째 자릿수가 리스트의 맨 앞에 위치하도록 배열된다는 뜻이다.
 */
public class Problem5_PartialSumTest {

    @Test
    void solution() {
        ListNode l1 = new ListNode(7);
        ListNode n2= new ListNode(1);
        ListNode n3 = new ListNode(6);
        ListNode l2 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(2);
        l1.setNext(n2);
        n2.setNext(n3);

        l2.setNext(n5);
        n5.setNext(n6);
        addList(l1, l2, 0);
    }

    ListNode addList(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.getVal();
        }
        if (l2 != null) {
            value += l2.getVal();
        }

        result.setData(value % 10);

        if (l1 != null || l2 != null) {
            ListNode more = addList(l1 == null ? null : l1.getNext(),
                                    l2 == null ? null : l2.getNext(),
                                    value >= 0 ? 1: 0);
            result.setNext(more);
        }
        return result;


    }

}
