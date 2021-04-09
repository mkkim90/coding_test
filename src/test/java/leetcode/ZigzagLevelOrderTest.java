package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 릿코드 103 Binary Tree Zigzag Level Order
 */
public class ZigzagLevelOrderTest {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        boolean flag = true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            int size = s.size();
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = s.pop();
                level.add(node.getVal());
                if (flag) {
                    if (node.getLeft() != null) newStack.push(node.getLeft());
                    if (node.getRight() != null) newStack.push(node.getRight());
                } else {
                    if (node.getRight() != null) newStack.push(node.getRight());
                    if (node.getLeft() != null) newStack.push(node.getLeft());
                }
            }
            ret.add(level);
            s = newStack;
            flag = !flag;
        }

        return ret;
    }
}
