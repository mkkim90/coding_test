package housesa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test2 {
    /**
     * "abcabcdefabc"	"def"
     * "abxdeydeabz"	"xyz"
     * "ibcabca"	"bcbc"
     * "ABCabcA"	"BCbc"
     */
    @DisplayName("오늘의 집 2")
    @Test
    void 최대_합() {
        String s = "abcabcdefabc";
        String upperCaseStr = s.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> maxKey = new ArrayList<>();
        for (char x : upperCaseStr.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) >= max) {
                max = map.get(key);
                maxKey.add(key);
            }
        }


        StringBuffer sb = new StringBuffer();
        for (char x : s.toCharArray()) {
            if (!maxKey.contains(Character.toUpperCase(x))) {
                sb.append(x);
            }
        }
        System.out.println(sb.toString());
    }
}
