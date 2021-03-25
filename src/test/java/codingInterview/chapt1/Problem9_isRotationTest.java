package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem9_isRotationTest {

    @Test
    void solution() {
        assertThat(isRotation("waterbottle", "erbottlewat")).isTrue();
    }

    private boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.indexOf(s2) > 0;
        }
        return false;
    }

}
