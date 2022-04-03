package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 큰_수_출력하기 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        큰_수_출력하기 t = new 큰_수_출력하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : t.solution(n, arr)) {
            System.out.println(x + " ");
        }

    }
}
