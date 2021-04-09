package treeGraph;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 최소 트리
 * 최소높이의 트리가 되려면 왼쪽 하위 트리의 노드의 개수와 오른쪽 하위 트리의 노드 개수가 같게 맞춰줘야함
 * 1. 배열 가운데 원소를 트리에 삽입한다.
 * 2. 왼쪽 하위 트리에 왼쪽 절반 배열 원소들을 삽입한다.
 * 3. 오른쪽 하위 트리에 오른쪽 절반 배열 원소들을 삽입한다.
 * 4. 재귀 호출을 실행한다.
 */
public class CreateMinimalBSTTest {
    @Test
    void solution() {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode n = createMinimalBST(arr, 0, arr.length -1);
        System.out.println(n);
    }

    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeft(createMinimalBST(arr, start, mid -1));
        n.setRight(createMinimalBST(arr, mid + 1, end));
        return n;
    }

}
