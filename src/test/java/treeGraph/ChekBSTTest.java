package treeGraph;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

public class ChekBSTTest {
    @Test
    void solution() {

    }

    boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if (min != null && n.getVal() <= min || max != null && n.getVal() > max) {
            return false;
        }

        if (!checkBST(n.getLeft(), min, n.getVal()) || !checkBST(n.getRight(), n.getVal(), max)) {
            return false;
        }
        return true;
    }
}
