package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 매출액의_종류 {
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) -1);
        }
        return answer;
    }

    public static void main(String[] args) {
        매출액의_종류 t = new 매출액의_종류();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(t.solution(a, b));
    }
}
