package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 141 릿코드 Linked List Cycle
 * 142 릿코드 Linked List Cycle
 * <p>
 * walker : 한번에 한칸씩
 * runner : 한번에 두칸씩 전진
 * <p>
 * xxxxx
 * x x
 * xxx
 * <p>
 * A : 시작노드부터 루프의 처음 노드까지 길이(2)
 * B : 루프 전체의 길이(8)
 * X : 루프의 처음노드부터 현재노드까지의 길이
 * <p>
 * walker와 runner가 만날때까지 간 거리
 * walker : A + X
 * runner : A + n*B + X
 * <p>
 * 2*walker = runner
 * 2 * (A + X) = A + (n * B) + X
 * 2A + 2X = A + (n * B) + X
 * A + X = n * B
 * 해당 공식을 응용하면,
 * X지점과 시작노드부터 두 워커를 전진시키면
 * 루프의 처음노드에서 만나게됨
 */
public class LinkedListCycleTest {
    private ListNode root = new ListNode();

    @DisplayName("순환링크드리스트 생")
    @BeforeEach
    void setUp() {
        root = createLinkedListCycle();
    }

    private ListNode createLinkedListCycle() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);
        ListNode ten = new ListNode(10);
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(eight);
        eight.setNext(nine);
        nine.setNext(ten);
        ten.setNext(three);
        return one;
    }

    @Test
    void detectCycleTest() {
        assertThat(detectCycle(root).getVal()).isEqualTo(3);
    }

    private ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        // walker와 runner가 만나는 시점으로 만듬
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
                walker = walker.next;
                if (runner == walker) {
                    break;
                }
            } else {
                break;
            }
        }

        if (runner == null) {
            return null;
        }

        // 두 워커를 전진시켜 루프의 처음노드에서 만나게 됨
        // check는 처음시점 walker는 runner와 만난 시점을 의
        ListNode check = head;
        while (check != walker) {
            check = check.next;
            walker = walker.next;
        }

        return check;
    }

    @Test
    void hasCyleTest() {
        assertThat(hasCycle(root)).isTrue();
    }

    private boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
                walker = walker.next;
                if (runner == walker) {
                    break;
                }
            } else {
                break;
            }
        }

        return runner != null;
    }
}
