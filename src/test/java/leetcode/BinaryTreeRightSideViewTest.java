package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeRightSideViewTest {
    @Test
    void solution() {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootLeftRight = new TreeNode(5);

        TreeNode rootRight = new TreeNode(3);
        TreeNode rootRightRight = new TreeNode(4);

        rootLeft.setRight(rootLeftRight);
        rootRight.setRight(rootRightRight);
        root.setRight(rootRight);
        root.setLeft(rootLeft);

        assertThat(rightSideView(root)).containsExactly(1,3,4);
    }

    List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1) ret.add(cur.getVal());
                if (cur.getLeft() != null) q.offer(cur.getLeft());
                if (cur.getRight() != null) q.offer(cur.getRight());
            }
        }

        return ret;
    }
}
