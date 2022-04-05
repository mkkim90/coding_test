package inflearn;

import java.util.Scanner;

public class 최대_매출 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0 , sum = 0;
        for (int i = 0; i < k; i++) {
            sum+= arr[i];
        }
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        최대_매출 t = new 최대_매출();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(n, k, arr));
    }
}
