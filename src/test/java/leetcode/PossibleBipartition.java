package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 이분그래프
 *
 * 싫어하는 사람끼리는 둘로 나뉘어질 수 없도록 하기 위함
 *
 */
public class PossibleBipartition {

    @Test
    void solution() {
        int N = 4;
        int[][] dislikes = {{1,2}, {1,3}, {2,4}};
        assertThat(possibleBipartition(N, dislikes)).isTrue();
    }

    @Test
    void solution2() {
        int N = 3;
        int[][] dislikes = {{1,2}, {1,3}, {2,3}};
        assertThat(possibleBipartition(N, dislikes)).isFalse();
    }


    /**
     * a-b
     *
     * a-b
     * |/
     * c
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();

        boolean[] visited = new boolean[N];
        boolean[] color = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] d : dislikes) {
            int a = d[0]-1;
            int b = d[1]-1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (!isBipartiteDfs(i, adjList, visited, color)) {
                    return false;
                }
            }
        }

        return true;
     }

    private boolean isBipartiteDfs(int i, List<List<Integer>> adjList, boolean[] visited, boolean[] color) {
        for (int next : adjList.get(i)) {
            if (!visited[next]) {
                visited[next] = true;
                color[next] = !color[i];
                if (!isBipartiteDfs(next, adjList, visited, color)) {
                    return false;
                }
            } else if (color[i] == color[next]) {
                return false;
            }
        }

        return true;
    }


}
