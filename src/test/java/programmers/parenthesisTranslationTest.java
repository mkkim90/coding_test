package programmers;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * p	result
 * "(()())()"	"(()())()"
 * ")("	"()"
 * "()))((()"	"()(())()"
 */
public class parenthesisTranslationTest {
    StringBuilder sb = new StringBuilder();
    int index;

    @Test
    void solution() {
        assertThat(getCorrectParenthesis("(()())()")).isEqualTo("(()())()");
        assertThat(getCorrectParenthesis(")(")).isEqualTo("()");
        assertThat(getCorrectParenthesis("()))((()")).isEqualTo("()(())()");
    }

    private boolean isCorrectParenthesis(String balancedParenthesis) {
        int strLen = balancedParenthesis.length();
        int open = 0;
        for (int i = 0; i < strLen; i++) {
            if (balancedParenthesis.charAt(i) == '(') {
                open++;
            } else {
                if (open == 0) return false;
                open--;
            }
        }
        return true;
    }

    private String getCorrectParenthesis(String balancedParenthesis) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (balancedParenthesis.length() == 0) return balancedParenthesis;

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int open = 0;
        int close = 0;
        for (char c : balancedParenthesis.toCharArray()) {
            if (c == '(') open++;
            else close++;
            if (open == close) break;
        }
        int uLen = open + close;
        String u = balancedParenthesis.substring(0, uLen);
        String v = balancedParenthesis.substring(uLen);

        if (isCorrectParenthesis(u)) {
            // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
            //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + getCorrectParenthesis(v);
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //   4-3. ')'를 다시 붙입니다.
            String uDash = "(" + getCorrectParenthesis(v) + ")";
            //   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for (int i = 1; i < uLen - 1; i++) {
                if (u.charAt(i) == '(') {
                    uDash += ")";
                } else {
                    uDash += "(";
                }
            }
            //   4-5. 생성된 문자열을 반환합니다.
            return uDash;
        }
    }
}
