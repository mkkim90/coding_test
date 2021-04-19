package programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * "aabbaccc"	7
 * "ababcdcdababcdcd"	9
 * "abcabcdede"	8
 * "abcabcabcabcdededededede"	14
 * "xababcdcdababcdcd"	17
 */
public class StringCompressionTest {

    @ParameterizedTest
    @CsvSource({"aabbaccc,7", "ababcdcdababcdcd,9", "abcabcdede,8", "abcabcabcabcdededededede, 14", "xababcdcdababcdcd, 17"})
    void solution(String str, int minCount) {
        assertThat(minOfStringCompressLength(str)).isEqualTo(minCount);
    }

    private int minOfStringCompressLength(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        // i는 간격
        for (int i = 1; i < s.length(); i++) {
            String currentSubString = "";
            String nextSubString = "";
            StringBuffer compress = new StringBuffer();
            int cnt = 0;
            // j와 i를 통해 문자열 잘라서 비교
            for (int j = 0; j * i <= s.length(); j++) {
                cnt++;
                currentSubString = nextSubString;
                nextSubString = s.substring(i * j, (i * (j + 1) > s.length()) ? s.length() : (i * (j + 1)));

                if (!currentSubString.equals(nextSubString)) {
                    if (cnt > 1) compress.append(cnt);
                    compress.append(currentSubString);
                    cnt = 0;
                }
            }
            // 마지막 처리
            if (cnt > 1) compress.append(cnt);
            compress.append(nextSubString);

            answer = Math.min(compress.toString().length(), answer);
        }

        return answer;
    }

    @DisplayName("재귀 활용한 문자열 압축")
    @ParameterizedTest
    @CsvSource({"aabbaccc,7", "ababcdcdababcdcd,9", "abcabcdede,8", "abcabcabcabcdededededede, 14", "xababcdcdababcdcd, 17"})
    void solution2(String str, int minCount) {
        assertThat(minStringCompress(str)).isEqualTo(minCount);
    }

    private int minStringCompress(String s) {
        int answer = 0;

        for (int i = 1; i <= (s.length() / 2) + 1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (answer > result ? result : answer);
        }

        return answer;
        
    }

    private String getSplitedLength(String s, int n, int repeat) {
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }

}
