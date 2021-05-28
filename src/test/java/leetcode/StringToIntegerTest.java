package leetcode;

import org.junit.jupiter.api.Test;

public class StringToIntegerTest {
    @Test
    void solution() {
        //  System.out.println(toInteger("   -42"));
        //  System.out.println(toInteger("-91283472332"));
        System.out.println(toInteger("3.14159"));
    }

    private int toInteger(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.length() < 2 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
            if (str.charAt(0) == '-') sign = -1;
            i++;
        }
        int n = 0;
        while (i < str.length()) {
            if (!Character.isDigit(str.charAt(i))) break;
            int d = str.charAt(i) - '0';
            if (n > (Integer.MAX_VALUE - d) / 10) { //Detect the integer overflow.
                n = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return n;
            }
            n = n * 10 + d;
            i++;
        }
        return sign * n;
    }
}

