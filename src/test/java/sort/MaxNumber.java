package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxNumber {

    @Test
    void solution() {
        int[] arr = {6, 10, 2};
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(result, (a, b) -> (b+a).compareTo(a+b));
        String answer = "";
        for (String s : result) {
            answer += s;
        }

        assertThat(answer).isEqualTo("6210");
    }

    // 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private void print(int[] arr, int r) {
        for (int i = 0; i <= r; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(" ");
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
