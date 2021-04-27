package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PyramidTransitionMatrixTest {

    @Test
    void pyramidTransition() {
        assertThat(pyramidTransition("BCD", Arrays.asList("BCG", "CDE", "GEA", "FFF"))).isTrue();
        assertThat(pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC"))).isFalse();

    }

    private Map<String, List<Character>> strToChar = new HashMap<String, List<Character>>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        for (String str : allowed) {
            strToChar.computeIfAbsent(str.substring(0, 2), i -> new ArrayList<>()).add(str.charAt(2));
        }
        return isPyramidTransition(bottom);
    }

    public boolean isPyramidTransition(String current) {
        // 루트는 하나
        if (current.length() == 1)
            return true;

        // 부모 리스트 추출 BCD 라면 BC의 루트인 G, CD의 루트인 E
        List<List<Character>> rootList = getRootLists(current);
        // 자식의 키에 따른 값이 없으면 false 반환
        if (rootList == null) return false;

        List<String> resultList = new ArrayList<String>();
        // 부모 리스트에서 나올수 있는 조합 추출 G,E라면 GE
        traverse(resultList, rootList, 0, new StringBuilder(""));

        for (int i = 0; i < resultList.size(); i++) {
            if (!isPyramidTransition(resultList.get(i)))
                return false;
        }
        return true;
    }

    private List<List<Character>> getRootLists(String current) {
        List<List<Character>> rootList = new ArrayList<List<Character>>();
        for (int i = 0; i < current.length() - 1; i++) {
            String substr = current.substring(i, i + 2);
            List<Character> currentList = strToChar.getOrDefault(substr, null);
            if (currentList == null) {
                return null;
            }
            rootList.add(currentList);
        }
        return rootList;
    }

    public void traverse(List<String> resultList, List<List<Character>> rootList, int index, StringBuilder sb) {
        if (index == rootList.size()) {
            resultList.add(sb.toString());
            return;
        }

        List<Character> currentRoots = rootList.get(index);
        for (int i = 0; i < currentRoots.size(); i++) {
            sb.append(currentRoots.get(i));
            traverse(resultList, rootList, index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
