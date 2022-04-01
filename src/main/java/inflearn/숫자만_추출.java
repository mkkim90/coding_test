package inflearn;

import java.util.Scanner;

public class 숫자만_추출 {
    public int solution(String s) {
        String answer = "";
        for (char x : s.toCharArray()) {
            //if (x > = 48 && x <=57) answer = answer * 10 + (x-48);
            if (Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        숫자만_추출 t = new 숫자만_추출();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(t.solution(str));
    }
}
