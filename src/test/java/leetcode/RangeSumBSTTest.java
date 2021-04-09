package leetcode;

public class RangeSumBSTTest {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        else if (root.getVal() < L) {
            return rangeSumBST(root.getRight(), L, R);
        } else {
            return rangeSumBST(root.getLeft(), L, R) + root.getVal() + rangeSumBST(root.getRight(), L, R);
        }
    }
}
