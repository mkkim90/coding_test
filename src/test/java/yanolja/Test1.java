package yanolja;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 *
 * R -> P
 * S -> R
 * P -> S
 */
public class Test1 {
    /**
     *  'SRR'
     * WRONG ANSWER (got 5 expected 4)
     *
     * Example test:   'PRPRRPP'
     * WRONG ANSWER (got 8 expected 10)
     *
     * Example test:   'PPPPRRSSSSS'
     */
    @Test
    void solution() {
        String G = "SRR";
        char[] list = G.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            map.put("S", map.getOrDefault("S", 0) + getPoint("S", list[i]));
            map.put("R", map.getOrDefault("R", 0) + getPoint("R", list[i]));
            map.put("P", map.getOrDefault("P", 0) + getPoint("P", list[i]));
        }

        Integer max = map.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        assertThat(max).isEqualTo(4);
    }

    private int getPoint(String key, char g) {
        if (key == "R") {
            if (g == 'S') {
                return 2;
            } else if (g == 'R') {
                return 1;
            }
            return 0;
        }

        else if (key == "S") {
            if (g == 'P') {
                return 2;
            } else if (g == 'S') {
                return 1;
            }
            return 0;
        }

        else if (key == "P") {
            if (g == 'R') {
                return 2;
            } else if ( g == 'P') {
                return 1;
            }

            return 0;
        }

        return 0;
    }
}
