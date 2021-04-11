package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestTest {
    int k;
    int i;
    int ret;

    @Test
    void solution() {

        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        two.setLeft(one);
        three.setLeft(two);
        three.setRight(four);
        five.setLeft(three);
        five.setRight(seven);
        k=3;
        assertThat(kthSmallest(five)).isEqualTo(3);

    }

    private int kthSmallest(TreeNode root) {
        i = 0;
        trace(root);
        return ret;
    }

    private boolean trace(TreeNode root) {
        if (root == null) return false;
        boolean b = trace(root.getLeft());
        if (b) return b;
        i++;
        if (i == k) {
            ret = root.getVal();
        }
        return trace(root.getRight());
    }
}
