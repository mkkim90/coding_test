package inflearn;

import java.util.Scanner;

public class 팰린드롬 {
    public String solution(String s) {
        String answer = "";
        s = s.toUpperCase().replaceAll("[^A-Z]]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        팰린드롬 t = new 팰린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(t.solution(str));
    }
}
