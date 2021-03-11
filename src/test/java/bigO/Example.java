package bigO;

import basic.TreeNode;
import org.junit.jupiter.api.Test;


/**
 * 빅오 계산 예제
 */
public class Example {

    /**
     * 예제 9
     * 균형 이진 탐색 드리에서 수행시간은 어떻게 되겠는가?
     * <p>
     * <p>
     * 트리의 각 노드를 한번씩 방문 한 뒤 각 노드에서 상수 시간에 해당하는 일을 수행한다.
     * <p>
     * 재귀 호출에 따라 O(분기^깊이)이므로 분기가 두개임으로 O(2^깊이)가 될 것이다.
     * 깊이는 총 N개의 노드가 있다면 깊이는 대략 log N이 된다.
     * <p>
     * 2^1ogN -> N이므로
     * <p>
     * 최종적으로, O(N)이 된다.
     */
    int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return sum(node.getLeft()) + node.getVal() + sum(node.getRight());
    }

    /**
     * 예제 10
     * 소수 구하기 함수 시간 복잡도 O(N제곱근)
     */
    boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 예제 11
     * n의 계승 (factorial) n! 을 구하는 코드이다.
     * 시간 복잡도는 어떻게 되는가?
     */
    int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return n * factorial(n - 1);
        }

        return n * factorial(n - 1);
    }

    /**
     * 예제 12
     * 문자열로 나타낼 수 있는 순열(permutation)의 개수를 구하는 코드이다.
     * <p>
     * 순열이 완성되는 시점에 permutation 함수에 몇 번이나 호출되는가
     * n!개의 순열이 존재한다는 뜻 -> n!번 호출
     * <p>
     * 순열 생성이 완성되기 전에 permutation함수는 몇 번이나 호출되는가
     * <p>
     * 노드로 생각해보자
     * ex) 1234
     * <p>
     * 234
     * /
     * 34, 12
     * /
     * 4, 123
     * /
     * 1234
     * <p>
     * 깊이는 4 이고 말단 노드는 4!
     * 그러므로 총 호출 횟수는 n*n!
     * <p>
     * 각 함수 호출을 처리하는 데 얼마나 오래 걸리나
     * O(N) 시간이 걸린다.
     * <p>
     * 총 수행시간은
     * n*n! 호출되고 한번 호출될 때마다 O(n)시간이 걸리므로 총 수행 시간은 O(n^2 * n!)을 넘지 않을 것이다.
     */
    @Test
    void permutation() {
        permutation("1234", "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    /**
     * 예제 14
     * 0부터 n까지의 피보나치 수열 전부를 출력
     * 피보나치 수열 O(2^n) -> 여러 횟수
     * 2^1 + 2^2 + 2^3 + 2^4 -> 2^n으로 구함
     */
    void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i));
        }
    }

    int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 예제 15
     * 피보나치 수열 메모리제이션
     * 캐시 배열에 다시 저장하고 반환해주기만 하면 된다. 이 일련의 과정은 상수 시간 안에 동작
     *
     * O(N)
     *
     */
    int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];
        memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }

    /**
     * 예제 16
     * 1과 n은 포함하여 그 사이에 있는 모든 2의 승수를 출력하는 함수
     * n이 4일때 이 함수는 1,2,4를 출력한다.
     * logN
     */
    int powerOf2(int n) {
        if (n < 1) {
            return 0;
        } else if (n==1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powerOf2(n /2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
}
