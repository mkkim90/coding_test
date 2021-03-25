package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

public class Problem5_oneEditAwayTest {
    @Test
    void solution() {
        oneEditAway("pal", "pa");

    }

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return onEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (second.length() + 1 == first.length()) {
            return oneEditInsert(second, first);
        }

        return false;
    }


    private boolean onEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;
            }
        }

        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
