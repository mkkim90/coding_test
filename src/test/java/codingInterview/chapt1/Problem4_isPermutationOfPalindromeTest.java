package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 회문일 시 홀수인 문자가 하나여야한다.
 * 항상 가운데인 문자 하나가 필요하기 때문이다.
 * 예를 들어서, tactcoapapa는 t가 2개, a가 4개, c가 2개, p가 2개, o가 1개 있으므로 회문의 순열이된다.
 * 즉 o는 항상 가운데 있어야한다.
 */
public class Problem4_isPermutationOfPalindromeTest {

    @Test
    void solution() {
        assertThat(isPermutationOfPalindrome("tactcoapapa")).isTrue();
    }

    private boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            table[x]++;
            if (table[x] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        return countOdd <= 1;
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if ( a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

}
