package leetcode;

import org.junit.jupiter.api.Test;

public class MergeTwoBinaryTreesTest {

    @Test
    void solution() {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        int val = (root1 == null ? 0 : root1.getVal()) + (root2 == null ? 0 : root2.getVal());
        TreeNode merge = new TreeNode(val);
        TreeNode rigtTree = mergeTrees(root1.getRight(),root2.getRight());
        merge.setRight(rigtTree);
        TreeNode leftTree = mergeTrees(root1.getLeft(), root2.getLeft());
        merge.setLeft(leftTree);
        return merge;
    }


}
