package leetcode;

import org.junit.jupiter.api.Test;

/**
 * 릿코드 701 Insert into a Binary Search Tree
 */
public class InsertIntoABinarySearchTreeTest {
    /**
     *     4
     *    / \
     *   2   7
     *  / \
     * 1  3
     *
     * 에서 5를 집어넣기 위해 재귀를 활용하여 이진탐색을 진행하게 된다.
     * 결과적으로,
     *     4
     *    /  \
     *   2    7
     *  / \  /
     * 1  3  5
     */
    @Test
    void solution() {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        two.setLeft(one);
        two.setRight(three);
        four.setLeft(two);
        four.setRight(seven);

        insertIntoBST(four, 5);

    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode child;
        if (root.getVal() < val) {
            child = insertIntoBST(root.getRight(), val);
            root.setRight(child);
        } else {
            child = insertIntoBST(root.getLeft(), val);
            root.setLeft(child);
        }

        return root;
    }
}
