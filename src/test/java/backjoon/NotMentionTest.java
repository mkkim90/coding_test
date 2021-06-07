package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3 4
 * ohhenrie
 * charlie
 * baesangwook
 * obama
 * baesangwook
 * ohhenrie
 * clinton
 */
public class NotMentionTest {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < n + m; i++) {
            String key = br.readLine();
            if (map.containsKey(key)) count++;
            map.put(key, map.getOrDefault(key, 0) +1);
        }

        System.out.println(count);
        for (String key : map.keySet()) {
            if (map.get(key) > 1) System.out.println(key);
        }

    }
}
