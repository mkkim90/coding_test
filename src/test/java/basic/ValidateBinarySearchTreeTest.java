package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateBinarySearchTreeTest {

    @Test
    void solution() {
        TreeNode root = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(1);

        root.setLeft(rootLeft);
        root.setRight(rootRight);
        assertThat(isValid(root)).isTrue();
    }

    boolean isValid(TreeNode root) {
        return isValid(root, false, false, 0, 0);
    }

    boolean isValid(TreeNode root, boolean lowerBoundExist, boolean upperBoundExist,
                    int lowerBound, int upperBound) {
        if (root == null) return true;
        // 베이스케이스 처리
        // 현재 노드가 lower / upperbound 침범하지 않는가
        if (lowerBoundExist && root.getVal() <= lowerBound) {
            return false;
        }
        if (upperBoundExist && root.getVal() >= upperBound) {
            return false;
        }

        // 그렇지 않다면 재귀적으로 확인
        return isValid(root.getLeft(), lowerBoundExist, true, lowerBound, root.getVal())
                && isValid(root.getRight(), true, upperBoundExist, root.getVal(), upperBound);

    }
}
