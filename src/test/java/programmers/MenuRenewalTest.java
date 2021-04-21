package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
 * ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
 * ["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
 */
public class MenuRenewalTest {
    Map<String, Integer> map = new HashMap<>();

    @Test
    void combinationTest() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] courses = {2,3,4};
        assertThat(menuRenewal(orders, courses)).containsExactly("WX", "XY");
    }

    private String[] menuRenewal(String[] orders, int[] courses) {
        for (String order : orders) {
            combinationString(order, courses);
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> answers = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == courses[i]) {
                    if (map.get(key) >= max_value) {
                        answers.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(answers);
        String[] result = new String[answers.size()];
        return answers.toArray(result);
    }

    private void combinationString(String str, int[] courses) {
        char[] numbers = str.toCharArray();
        Arrays.sort(numbers);
        boolean[] visited = new boolean[numbers.length];

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] <= numbers.length)
                combination(numbers, visited, 0, numbers.length, courses[i]);
        }
    }

    private void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            String comb = "";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    comb += arr[i];
                }
            }
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}
