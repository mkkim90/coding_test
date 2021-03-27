package codingInterview.chapt10;

import org.junit.jupiter.api.Test;

/**
 * 10.1 정렬된 병합 : 정렬된 배열 A,B가 주어진다. A의 끝에는 전부 넣을 수 있을 만큼 충분한 여유 공간이 있다.
 * B와 A를 정렬된 상태로 병합하는 메서드를 작성하라.
 */
public class Problem1_mergedTest {
    @Test
    void solution() {
        int[] a = new int[20];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        a[5] = 6;
        int[] b = {2,3,4,5,7};
        merge(a,b, 6, 5);
    }

    void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}
