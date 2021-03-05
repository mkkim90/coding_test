package treeGraph;

import basic.Graph;
import basic.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class PathBetweenNodes {


    @Test
    void solution() {
        Node child1= new Node(5);
        Node child2 = new Node(6);
        List<Node> childrenOfChild3 = Arrays.asList(child1, child2);
        Node child3 = new Node(3, childrenOfChild3);
        Node child4 = new Node(2);
        List<Node> childrenOfRoot = Arrays.asList(child3, child4);
        Node root = new Node(1, childrenOfRoot);

        boolean isPath = search(root, child1);
        assertThat(isPath).isTrue();

    }
    private boolean search(Node start, Node end) {
        if (start == end) return true;

        Queue<Node> q = new LinkedList<>();

        start.changeVisited(true);
        q.add(start);
        while (!q.isEmpty()) {
            Node u = q.poll();
            if (u != null) {
                for (Node v : u.children()) {
                    if (v.visited() == false && v == end) {
                        return true;
                    }
                    v.changeVisited(true);
                    q.add(v);
                }
            }
            u.changeVisited(true);
        }

        return false;
    }
}
