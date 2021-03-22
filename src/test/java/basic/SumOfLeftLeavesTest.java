package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfLeftLeavesTest {

    /**
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     *
     *     9+15 = 24
     */
    @Test
    void solution() {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        assertThat(sumOfLeftLeaves(root)).isEqualTo(24);

    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode treeNode) {
        if (treeNode != null) traverse(treeNode);
        return sum;
    }

    private boolean traverse(TreeNode treeNode) {
        if (treeNode.getLeft() != null) {
            if (traverse(treeNode.getLeft())) {
                sum += treeNode.getLeft().getVal();
            }
        }
        if (treeNode.getRight() != null) {
            traverse(treeNode.getRight());
        }

        return treeNode.getLeft() == null && treeNode.getRight() == null;
    }

}
