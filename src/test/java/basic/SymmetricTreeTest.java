package basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 릿코드 101 Symmetric Tree
 * 대칭 트리 여부 확인
 *
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 */
public class SymmetricTreeTest {
    private TreeNode root;

    /**
     *      1
     *     / \
     *    2   2
     *   / \ / \
     *  3  4 4  3
     */
    @BeforeEach
    void setUp() {
        root = new TreeNode(1);
        TreeNode branch1 = new TreeNode(2);
        TreeNode branch2 = new TreeNode(2);
        TreeNode leaf1 = new TreeNode(3);
        TreeNode leaf2 = new TreeNode(4);
        TreeNode leaf3 = new TreeNode(4);
        TreeNode leaf4 = new TreeNode(3);
        root.setLeft(branch1);
        root.setRight(branch2);
        branch1.setLeft(leaf1);
        branch1.setRight(leaf2);
        branch2.setLeft(leaf3);
        branch2.setRight(leaf4);
    }

    @Test
    void solution() {
        assertThat(isSymmetric(root)).isTrue();
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.getLeft(), root.getRight());
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if ( a == null && b == null ) return true;
        if ( a == null || b== null) return false;
        if (a.getVal() != b.getVal()) return false;
        return compare(a.getLeft(), b.getRight()) && compare(a.getRight(), b.getLeft());
    }
}
