package codingInterview.chapt2;

import basic.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 교집합 : 단방향 연결리스트 두 개가 주어졌을 때 이 두 리스트의 교집합 노드를 찾은 뒤 반환하는 코드를 작성하라.
 *
 * 1. 각 연결리스트를 순회하면서 길이와 마지막 노드를 구한다.
 * 2. 마지막 노드를 비교한 뒤, 그 참조값이 다르다면 교집합이 없다는 사실을 바로 반환한다.
 * 3. 두 연결리스트의 시작점에 포인트를 놓는다.
 * 4. 길이가 더 긴 리스트의 포인터를 두 길이의 차이만큼 앞으로 움직인다.
 * 5. 두 포인터가 같아질 때까지 두 리스트를 함께 순회한다.
 */
public class Problem7_FindIntersectionTest {

    @Test
    void solution() {
    }

    ListNode findIntersection(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;

        /**
         * 마지막 노드와 길이를 구한다.
         */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /**
         * 마지막 노드가 다르면 교집합이 없다는 뜻
         */
        if (result1.tail != result2.tail) {
            return null;
        }
        /**
         * 각 연결리스트의 시작점에 포인터를 세팅한다.
         */
        ListNode shorter = result1.size < result2.size ? list1 : list2;
        ListNode longer = result1.size < result2.size ? list2 : list1;

        /**
         * 길이가 긴 연결리스트의 포인터를 길이의 차이만큼 앞으로 움직인다.
         */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /**
         * 두 포인터가 만날 때까지 함께 앞으로 움직인다.
         */
        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }

        return longer;
    }

    class Result {
        public ListNode tail;
        public int size;

        public Result(ListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    Result getTailAndSize(ListNode list) {
        if (list == null) return null;

        int size = 1;
        ListNode current = list;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return new Result(current, size);
    }

    ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        while (k > 0 && current != null) {
            current = current.getNext();
            k--;
        }
        return current;
    }

}
