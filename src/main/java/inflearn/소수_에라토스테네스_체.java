package inflearn;

import java.util.Scanner;

public class 소수_에라토스테네스_체 {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j+1) ch[j] = 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        소수_에라토스테네스_체 t = new 소수_에라토스테네스_체();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(t.solution(n));
    }
}
