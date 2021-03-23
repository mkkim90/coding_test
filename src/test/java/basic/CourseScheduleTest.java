package basic;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 위상정렬
 * 1. indegree = 0 인것을 탐색
 * 2. 관련 엣지를 제거, indegree 업데이트
 *
 * 이렇게 1,2를 반복하게 됨
 *
 * 루프 종료 후, 모든 노드를 탐색했는지 확
 */
public class CourseScheduleTest {

    @Test
    void solution() {
        int numCourse = 2;
        int[][] p = {{1,0}};
        assertThat(canFinish(numCourse,p)).isTrue();
    }

    public boolean canFinish(int numCourses, int[][] p) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : p) {
            indegree[edge[0]]++;
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        // 1. indegree = 0 인것을 탐색
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        // 2. 관련 엣지를 제거, indegree 업데이트
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            for (int dest : adjList.get(node)) {
                if (--indegree[dest] == 0) q.offer(dest);
            }
            adjList.get(node).clear();
        }
        return visited.size() == numCourses;
    }


}
