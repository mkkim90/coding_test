package inflearn;

import java.util.Scanner;

public class 연속된_자연수의_합_2 {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n-cnt;
            if (n % cnt ==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        연속된_자연수의_합_2 t = new 연속된_자연수의_합_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(t.solution(n));
    }
}
