package basic;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumDepthOfNaryTree {
    @Test
    void solution() {
        Node child1= new Node(5);
        Node child2 = new Node(6);
        List<Node> childrenOfChild3 = Arrays.asList(child1, child2);
        Node child3 = new Node(3, childrenOfChild3);
        Node child4 = new Node(2);
        List<Node> childrenOfRoot = Arrays.asList(child3, child4);
        Node root = new Node(1, childrenOfRoot);
        //int depth = maximumDepthOfNaryTree(root);
        List<LinkedList<Node>> result = getLinkedList(root);
        assertThat(result.size()).isEqualTo(3);
        // assertThat(depth).isEqualTo(3);
    }

    private int maximumDepthOfNaryTree(Node root) {
        if (root == null ) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
           int size = q.size();
           for (int i = 0; i < size; i++) {
                Node u = q.poll();
                for (Node child : u.children()) {
                    q.add(child);
                }
            }
        }
        return depth;
    }

    private List<LinkedList<Node>> getLinkedList(Node root) {
        if (root == null ) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        List<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> roots = new LinkedList<>();
        roots.add(root);
        result.add(roots);
        while (!q.isEmpty()) {
            depth++;
            LinkedList<Node> list = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node u = q.poll();
                for (Node child : u.children()) {
                    q.add(child);
                    list.add(child);
                }
            }
            result.add(list);

        }
        return result;
    }

}
