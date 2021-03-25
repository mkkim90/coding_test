package codingInterview.chapt1;

import org.junit.jupiter.api.Test;

/**
 * 1.3 URLify : 문자열에 들어 있는 모든 공백을 %20으로 바꾸는 메서드
 * 문자열내에 얼마나 많은 공백이 있는지 확인 후 추가공간을 계산한다.
 * 두번째로 훑을 때에는 역방향으로 진행하면서 실제로 문자열을 편집한다.
 */
public class Problem3_ReplaceSpacesTest {

    @Test
    void solution() {
        char[] str = new char[128];
        str[0] = 'M';
        str[1] = 'r';
        str[2] = ' ';
        str[3] = 'J';
        str[4] = 'o';
        str[5] = 'h';
        str[6] = 'n';
        str[7] = ' ';
        str[8] = 'S';
        str[9] = 'm';
        str[10] = 'i';
        str[11] = 't';
        str[12] = 'h';



        replaceSpaces(str, 13);
    }

    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int j = 0; j < trueLength; j++) {
            if (str[j] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (int j = trueLength-1; j >= 0 ; j--) {
            if (str[j] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index -3;
            } else {
                str[index - 1] = str[j];
                index--;
            }
        }
    }
}
