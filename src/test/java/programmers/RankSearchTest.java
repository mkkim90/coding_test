package programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RankSearchTest {
    private Map<String, List<Integer>> map = new HashMap<>();

    @Test
    void rankSearchTest() {
        String[] infos = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] querys = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        assertThat(solution(infos, querys)).containsExactly(1,1,1,1,2,4);
    }

    private void combination(String[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            StringBuffer query = new StringBuffer();
            for (int i = 0; i < 4; i++) {
                if(visited[i]) query.append(arr[i]);
            }

            map.computeIfAbsent(query.toString(), s -> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }

        for (int i = start; i < 4; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    public int[] solution(String[] infos, String[] query) {
        combinationProcess(infos);
        sort();
        return rankSearchCounts(query);
    }

    private void sort() {
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            entry.getValue().sort(null);
        }
    }

    private int[] rankSearchCounts(String[] query) {
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] splits = query[i].replaceAll("-", "").replaceAll(" and ", "").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int matchCount = binarySearch(score, list);
            answer[i] = matchCount;
        }
        return answer;
    }

    private void combinationProcess(String[] infos) {
        for (String info : infos) {
            String[] splits = info.split(" ");
            boolean[] visited = new boolean[splits.length];

            for (int i = 0; i < splits.length; i++) {
                combination(splits, visited, 0, i);
            }
        }
    }

    private int binarySearch(int score, List<Integer> list) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int matchCount = list.size() - start;
        return matchCount;
    }
}
