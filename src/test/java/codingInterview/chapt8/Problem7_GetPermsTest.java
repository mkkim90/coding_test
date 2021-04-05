package codingInterview.chapt8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 8.7 중복 없는 순열 : 문자열이 주어졌을 때 모든 경우의 순열을 계산하는 메서드를 작성하라. 단, 문자는 중복되어 나타날 수 없다.
 */
public class Problem7_GetPermsTest {

    @Test
    void solution() {
        ArrayList<Integer> list = new ArrayList<>();
        getPerms("123");
    }

    ArrayList<String> getPerms(String str) {
        ArrayList<String> result = new ArrayList<String>();
        getPerms("", str, result);
        return result;
    }

    private void getPerms(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i+1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + after, result);
        }
    }


}
