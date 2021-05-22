package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Maximum Depth of Binary Tree
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 */
public class MaximumDepthOfBinaryTreeTest {
    private TreeNode root = new TreeNode(3);

    @BeforeEach
    void setUp() {
        TreeNode rootLeft = new TreeNode(9);

        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);

        rootRight.setRight(rootRightRight);
        rootRight.setLeft(rootRightLeft);
        root.setRight(rootRight);
        root.setLeft(rootLeft);
    }

    private int count;
    @Test
    void solution() {
        assertThat(dfs(root)).isEqualTo(3);
    }

    /**
     * void search(Node root) {
     * 	if (root == null) return;
     * 	visit(root);
     * 	root.visited = true
     * 	for (Node n : root.adjacent) {
     * 		if (n.vistied == false) {
     * 			search(n);
     *                }* 	}
     * }
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.getLeft()),dfs(root.getRight()));
    }
}
