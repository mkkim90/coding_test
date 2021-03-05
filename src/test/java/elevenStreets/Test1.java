package elevenStreets;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Test1 {
    @Test
    void solution() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer number : numbers) {
            m.put(number, m.getOrDefault(number, 0) + 1);
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer key : m.keySet()) {
            if (m.get(key) == 1) uniqueNumbers.add(key);
        }

        return uniqueNumbers;
    }

    /*
     * abbcbbb -> abcb
     * 스택 활용
     *
     * */
    @Test
    void solution2() {
        System.out.println(transform("abbcbbb"));
    }

    public static String transform(String input) {
        char[] inputs = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : inputs) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() != c) {
                stack.push(c);
            }
        }
        StringBuffer transform = new StringBuffer();
        while (!stack.empty()) {
            transform.insert(0, stack.pop());
        }

        return transform.toString();
    }
}
