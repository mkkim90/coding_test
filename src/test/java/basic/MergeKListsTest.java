package basic;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * 릿코드 23 Merge k Sorted Lists
 */
public class MergeKListsTest {
    @Test
    void solution() {
        ListNode[] list = new ListNode[3];
        list[0] = getNode(1,4,5);
        list[1] = getNode(1,3,4);
        list[2] = getNode(2,6);
        mergeKLists(list);
    }

    private ListNode getNode(int a, int b) {
        ListNode node =  new ListNode(a);
        ListNode nodeNext = new ListNode(b);
        node.setNext(nodeNext);
        return node;
    }

    private ListNode getNode(int a, int b, int c) {
        ListNode node =  new ListNode(a);
        ListNode nodeNext = new ListNode(b);
        nodeNext.setNext(new ListNode(c));
        node.setNext(nodeNext);
        return node;
    }

    private ListNode mergeKLists(ListNode[] list) {
        if (list == null || list.length == 0) return null;
        ListNode ret = null;
        ListNode cur = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(list.length,
                (a,b) -> a.getVal() - b.getVal());

        for (ListNode node : list) {
            if (node == null) continue;
            pq.offer(node);
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.offer(node.next);
            if (ret == null) {
                ret = node;
                cur = node;
            } else {
                cur.next = node;
                cur = node;
            }
        }

        return ret;
    }

}
