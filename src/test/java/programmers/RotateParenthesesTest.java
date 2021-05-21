package programmers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateParenthesesTest {
    @Test
    void solution() {
        int answer = rotateParentheses("[](){}");
        assertThat(answer).isEqualTo(3);
        assertThat(rotateParentheses("}]()[{")).isEqualTo(2);
    }

    private int rotateParentheses(String s) {
        List<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (validParentheses(q)) answer++;
            char c = q.remove(0);
            q.add(c);
        }

        return answer;
    }

    private boolean validParentheses(List<Character> parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.size(); i++) {
            char parenthese = parentheses.get(i);
            if (parenthese == '(' || parenthese== '[' || parenthese == '{') {
                stack.push(parenthese);
            } else if (parenthese == ')' && (stack.size() == 0 || stack.pop() != '(')) {
                return false;
            } else if (parenthese == ']' && (stack.size() == 0 || stack.pop() != '[')) {
                return false;
            } else if (parenthese == '}' && (stack.size() == 0 || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.size() == 0;
    }

}
