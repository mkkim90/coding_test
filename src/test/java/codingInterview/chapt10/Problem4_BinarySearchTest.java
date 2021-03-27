package codingInterview.chapt10;

import java.util.List;

/**
 * 10.4 크기를 모르는 정렬된 원소 탐색 : 배열과 비슷하지만 size메소드가 없는 Listy라는 자료구조가 있다.
 * 여기에는 i인덱스에 위치한 원소를 O(1) 시간에 알 수 있는 elementAt(i) 메소드가 존재한다.
 */
public class Problem4_BinarySearchTest {

    int search(List<Integer> list, int value, int low, int high) {
        int index = 1;
        while (list.get(index) != -1 && list.get(index) < value) {
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index);
    }

    private int binarySearch(List<Integer> list, int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int middle = list.get(mid);
            if (middle > value || middle == -1) {
                high = mid -1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
