package treeGraph;

import basic.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 깊이의 리스트
 * 같은 깊이에 있는 노드를 연결리스트로 연결해 주는 알고리즘
 */
public class CreateLevelLinkedListTest {
    @Test
    void solution() {
    }

    // 재귀 활용 DFS
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList list = null;
        if (lists.size() == level) { // 리스트에 해당 레벨이 없다
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.getLeft(), lists, level + 1);
        createLevelLinkedList(root.getRight(), lists, level + 1);
    }

    // 큐 활용 BFS
    List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList();
            for (TreeNode parent : parents) {
                if (parent.getLeft() != null) {
                    current.add(parent.getLeft());
                }

                if (parent.getRight() != null) {
                    current.add(parent.getRight());
                }
            }
        }

        return result;
    }
}
