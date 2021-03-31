package basic;

public class KthSmallestTest {
    int k;
    int i;
    int ret;

    private int kthSmallest(TreeNode root, int k) {
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
