package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 보이는_학생 {
    public int  solution(int n, int[] arr) {
        int answer = 1, max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        보이는_학생 t = new 보이는_학생();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(n, arr));

    }
}
