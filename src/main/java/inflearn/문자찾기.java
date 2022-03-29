package inflearn;

import java.util.Scanner;

public class 문자찾기 {
    public int solution(String str, char t) {
        int answer=0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        문자찾기 t = new 문자찾기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(t.solution(str, c));
    }
}
