package treeGraph;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

public class IsBalancedTest {
    @Test
    void solution() {
    }

    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == -1) return leftHeight;

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -1) return rightHeight;

        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return -1;
        } else {
            return 1;
        }
    }
}
