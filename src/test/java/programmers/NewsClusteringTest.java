package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
 * 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
 * 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
 * str1	str2	answer
 * FRANCE	french	16384
 * handshake	shake hands	65536
 * aa1+aa2	AAAA12	43690
 * E=M*C^2	e=m*c^2	65536
 */
public class NewsClusteringTest {

    @Test
    void solution() {
        assertThat(jaccardSimilarity("FRANCE", "french")).isEqualTo(16384);
        assertThat(jaccardSimilarity("handshake", "shake hands")).isEqualTo(65536);
        assertThat(jaccardSimilarity("aa1+aa2", "AAAA12")).isEqualTo(43690);
        assertThat(jaccardSimilarity("E=M*C^2", "e=m*c^2")).isEqualTo(65536);
    }

    private int jaccardSimilarity(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> str1map = new HashMap<>();
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            if (!key.matches("^[a-zA-Z]*$")) continue;
            str1map.put(key, str1map.getOrDefault(key, 0) + 1);
            keys.add(key);
        }

        Map<String, Integer> str2map = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            if (!key.matches("^[a-zA-Z]*$")) continue;
            str2map.put(key, str2map.getOrDefault(key, 0) + 1);
            keys.add(key);
        }

        int unionSize = 0;
        int crossSize = 0;
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (str2map.containsKey(key) && str1map.containsKey(key)) {
                int a = str2map.get(key);
                int b = str1map.get(key);
                unionSize += Math.max(a, b);
                crossSize += Math.min(a, b);
                continue;
            }

            if (str2map.containsKey(key)) unionSize += str2map.get(key);
            if (str1map.containsKey(key)) unionSize += str1map.get(key);

        }
        if (crossSize == unionSize) return 65536;
        double similarity = (double) crossSize / unionSize;
        return (int) (similarity * 65536);
    }
}
