package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JadenCaseTest {
    @Test
    void solution() {
        String s = "3people unFollowed me";
        String[]ss =  s.split(" ");
        StringBuffer result = new StringBuffer();
        for (String str : ss) {
            result.append(jaden(str));
            result.append(" ");
        }
        //result.toString().trim();
        assertThat(result.toString().trim()).isEqualTo("3people Unfollowed Me");
    }

    private String jaden(String str) {
        String lowerStr = str.toLowerCase();
        String first = lowerStr.substring(0,1);
        return lowerStr.replaceFirst(first, first.toUpperCase());
    }

    private boolean isAlpabet(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }


    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] sp = s.toLowerCase().split("");
            boolean flag = true;

            for(String ss : sp) {
                answer += flag ? ss.toUpperCase() : ss;
                flag = ss.equals(" ") ? true : false;
            }

            return answer;
        }

        private String jaden(String str) {
            String lowerStr = str.toLowerCase();
            String first = lowerStr.substring(0,1);
            return lowerStr.replaceFirst(first, first.toUpperCase());
        }

        private boolean isAlpabet(char c) {
            return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
        }
    }

}
