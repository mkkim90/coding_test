package backjoon;

import java.util.Scanner;

public class MakeOneTest {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int num = sc.nextInt();
        dp = new Integer[num + 1];
        dp[0] = 0;
        dp[1] = 0;
        System.out.println(oneMake(num));
    }

    private static int oneMake(int N) {
        if (dp[N] != null) return dp[N];

        if (N % 6 == 0) {
            dp[N] = Math.min(oneMake(N - 1), Math.min(oneMake(N / 3), oneMake(N / 2))) + 1;
            return dp[N];
        }

        if (N % 3 == 0) {
            dp[N] = Math.min(oneMake(N / 3), oneMake(N - 1)) + 1;
            return dp[N];
        }

        if (N % 2 == 0) {
            dp[N] = Math.min(oneMake(N / 2), oneMake(N - 1)) + 1;
            return dp[N];
        }

        dp[N] = oneMake(N - 1) + 1;
        return dp[N];
    }
}
