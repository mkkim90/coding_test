package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int val;
    private List<Node> children = new ArrayList<>();
    private boolean visited = false;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Integer val() {
        return val;
    }

    public List<Node> children() {
        return children;
    }

    public void changeVisited(boolean state) {
        this.visited = state;
    }

    public boolean visited() {
        return this.visited;
    }
}
