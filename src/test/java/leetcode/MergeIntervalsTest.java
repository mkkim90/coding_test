package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 릿코드 56 Merge Intervals
 */
public class MergeIntervalsTest {
    @Test
    void solution() {
        List<Intervals> result =  mergeIntervals(Arrays.asList(new Intervals(1, 3), new Intervals(2, 6), new Intervals(8, 10), new Intervals(15, 18)));
        assertThat(result.size()).isEqualTo(3);
    }

    private List<Intervals> mergeIntervals(List<Intervals> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        List<Intervals> ret = new ArrayList<>();

        Collections.sort(intervals, (a,b) -> a.getStart() - b.getStart());

        for (int i = 1; i < intervals.size(); i++) {
            Intervals a = intervals.get(i-1);
            Intervals b = intervals.get(i);
            if (a.getEnd() >= b.getStart() && b.getEnd() >= a.getStart()) {
                b.setStart(Math.min(a.getStart(), b.getStart()));
                b.setEnd(Math.max(a.getEnd(), b.getEnd()));
            } else {
                ret.add(a);
            }
        }
        ret.add(intervals.get(intervals.size()-1));
        return ret;

    }
}
