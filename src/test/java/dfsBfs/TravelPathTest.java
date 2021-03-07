package dfsBfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * tickets	return
 * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
 * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class TravelPathTest {
    List<Stack<String>> result;
    String[][] tickets;
    @Test
    void solution() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        result = new ArrayList<>();
        this.tickets = tickets;
        boolean[] visited = new boolean[tickets.length];
        Stack<String> st = new Stack<>();
        st.push("ICN");

        dfs(visited, st, 0);
        assertThat(result.size()).isEqualTo(6);
    }


    void dfs(boolean[] visited, Stack<String> st, int len) {
        if (len == tickets.length) {
            Stack<String> res = new Stack<>();
            for (String s : st) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        String arrive = st.peek();

        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];

            if (!visited[i] && arrive.equals(tic[0])) {
                st.push(tic[1]);
                visited[i] = true;

                dfs(visited, st, len + 1);

                visited[i] = false;
                st.pop();
            }
        }
    }
}
