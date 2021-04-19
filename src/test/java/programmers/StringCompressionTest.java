package programmers;

import org.junit.jupiter.api.Test;

public class StringCompressionTest {
    @Test
    void solution() {

    }

    private int minOfStringCompressLength(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        // 문자열 기준 1~length 까지
        for (int i = 1; i < s.length(); i++) {
            String now = "";
            String comp = "";
            String temp = "";
            int cnt = 1;

            // j 기준 단위 0부터 length/i 단위까지
            // 나누어 떨어지지않을때 끝까지 계산해주려면 <=
            for (int j = 0; j <= s.length() / i; j++) {
                int from = i * j;
                int to = i * (j + 1);
                // 값 넘을 시 보정
                if (to > s.length()) to = s.length();

                // 기준점 변경
                now = comp;
                comp = s.substring(from, to);

                // 비교
                if (now.equals(comp)) cnt++;
                else {
                    if (cnt > 1) temp += String.valueOf(cnt);
                    temp += now;
                    cnt = 1; // 개수 초기화
                }
            }
            // 남은값 처리
            if (cnt > 1) temp += String.valueOf(cnt);
            temp += comp;
            // 갱신
            answer = Math.min(temp.length(), answer);
        }

        return answer;
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
