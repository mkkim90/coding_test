package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupPictureTest {
    private int count;
    private String[] conditions;

    @Test
    void pemutationTest() {
        conditions = new String[]{"N~F=0", "R~T>2"};
        permutation("ACFJMNRT", "");
        assertThat(count).isEqualTo(3648);
    }

    void permutation(String reminder, String prefix) {
        if (reminder.length() == 0 && check(prefix)) {
            count++;
            return;
        }

        for (int i = 0; i < reminder.length(); i++) {
            permutation(reminder.substring(0, i) + reminder.substring(i + 1), prefix + reminder.charAt(i));
        }
    }

    boolean check(String str) {
        for (String condition : conditions) {
            char a = condition.charAt(0);
            char b = condition.charAt(2);
            char op = condition.charAt(3);
            int res = condition.charAt(4) - '0' + 1;

            int distance = Math.abs(str.indexOf(a) - str.indexOf(b));
            if (op == '=' && distance != res) return false;
            else if (op == '>' && distance <= res) return false;
            else if (op == '<' && distance >= res) return false;
        }
        return true;
    }

}
