package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */
public class BinaryTreeZigzagLevelOrderTraversalTest {
    private TreeNode root = new TreeNode(3);

    @BeforeEach
    void setUp() {
        TreeNode rootLeft = new TreeNode(9);

        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);

        rootRight.setRight(rootRightRight);
        rootRight.setLeft(rootRightLeft);
        root.setRight(rootRight);
        root.setLeft(rootLeft);
    }

    @Test
    void solution() {
        List<List<Integer>> result = bfs(root);
        for (List<Integer> c : result) {
            for (int num : c) System.out.println(num);
        }
    }

    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null) return wrapList;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().getLeft() != null) q.offer(q.peek().getLeft());
                if (q.peek().getRight() != null) q.offer(q.peek().getRight());
                curList.add(q.poll().getVal());
            }

            if (!curList.isEmpty() && count % 2 == 1) Collections.reverse(curList);

            count++;
            wrapList.add(curList);
        }
        return wrapList;
    }
}
