package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class KNumTest {

    @Test
    void solution() {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[] command = {2, 5, 3};

        List<Integer> result = Arrays.stream(arr, command[0]-1, command[1]).sorted().boxed().collect(Collectors.toList());
        assertThat(result.get(command[2]-1)).isEqualTo(5);
    }

    /**
     * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
     */
    @Test
    void solutioon2() {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4,4,1}, {1,7,3}};
        assertThat(kNumber(arr, commands)).containsExactly(5,6,3);
    }



    private int[] kNumber(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
