package programmers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * N	road	K	result
 * 5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4
 * 6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
 */
public class DeliveryTest {
    private static class Delivery {
        int start;
        int cost;

        Delivery(int start, int time) {
            this.start = start;
            this.cost = time;
        }
    }

    @Test
    void solution() {
        int N = 6;
        int k = 4;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};

        int[] dist = bfs(1, road, N);
        int answer = 0;
        for (int i : dist)
            if (i <= k) answer++;
        assertThat(answer).isEqualTo(4);
    }


    private int[] bfs(int start, int[][] road, int N) {
        int[] dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) dist[i] = 500001;
        dist[start] = 0;

        Queue<Delivery> q = new LinkedList<>();
        q.add(new Delivery(start, 0));

        while (!q.isEmpty()) {
            Delivery current = q.poll();
            int currentCost = current.cost;
            int currentStart = current.start;
            if (currentCost > dist[currentStart]) continue;
            for (int i = 0; i < road.length; i++) {
                if (road[i][0] == currentStart) {
                    int totalCost = road[i][2] + currentCost;
                    int end = road[i][1];
                    if (totalCost < dist[end]) {
                        dist[end] = totalCost;
                        q.add(new Delivery(end, totalCost));
                    }
                } else if (road[i][1] == currentStart) {
                    int totalCost = road[i][2] + currentCost;
                    int end = road[i][0];
                    if (totalCost < dist[end]) {
                        dist[end] = totalCost;
                        q.add(new Delivery(end, totalCost));
                    }
                }
            }
        }
        return dist;

    }
}
