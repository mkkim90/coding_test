package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PyramidTransitionMatrixTest {

    @Test
    void pyramidTransition() {
        assertThat(pyramidTransition("BCD", Arrays.asList("BCG", "CDE", "GEA", "FFF"))).isTrue();
        assertThat(pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC"))).isFalse();
    }

    private Map<String, List<Character>> allowedMap = new HashMap<String, List<Character>>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        for (String str : allowed) {
            allowedMap.computeIfAbsent(str.substring(0, 2), i -> new ArrayList<>()).add(str.charAt(2));
        }
        return isPyramidTransition(bottom);
    }

    public boolean isPyramidTransition(String bottom) {
        // 루트 하나일 경우 최상루트이므로 종료
        if (bottom != null && bottom.length() == 1)
            return true;

        // 부모 리스트 추출
        // BCD일때 BC의 루트인 G와 CD의 루트인 E를 추출합니다.
        // 루트 값이 없으 false 반환
        List<List<Character>> roots = getRoots(bottom);
        if (roots == null) return false;

        // 부모 리스트에서 나올수 있는 조합 추출하여 자식노들리스트 활용 G,E라면 GE
        List<String> bottoms = new ArrayList<String>();
        combination(bottoms, roots, 0, new StringBuilder(""));

        // 재귀
        for (int i = 0; i < bottoms.size(); i++) {
            if (!isPyramidTransition(bottoms.get(i)))
                return false;
        }
        return true;
    }

    private List<List<Character>> getRoots(String chillds) {
        List<List<Character>> roots = new ArrayList<List<Character>>();
        for (int i = 0; i < chillds.length() - 1; i++) {
            List<Character> currentList = allowedMap.getOrDefault(chillds.substring(i, i + 2), null);
            if (currentList == null) {
                return null;
            }
            roots.add(currentList);
        }
        return roots;
    }

    public void combination(List<String> resultList, List<List<Character>> rootList, int index, StringBuilder sb) {
        if (index == rootList.size()) {
            resultList.add(sb.toString());
            return;
        }

        List<Character> currentRoots = rootList.get(index);
        for (int i = 0; i < currentRoots.size(); i++) {
            sb.append(currentRoots.get(i));
            combination(resultList, rootList, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
