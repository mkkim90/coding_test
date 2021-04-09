package cousa;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * grades	result
 * ["DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"]
 * ["DS7651 A+", "OS1808 B-", "DB0001 B-", "AI5543 C0", "CA0055 D+", "AI0001 F"]
 * ["DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"]	["GP0000 A0", "PL6677 B+", "DM0106 B+"]
 *
 * DS7651	A+
 * OS1808	B-
 * DB0001	B-
 * AI5543	C0
 * CA0055	D+
 * AI0001	F
 *
 */
public class Test2 {
    Map<String, Integer> scoreWeight = new HashMap<>();

    @Test
    void solution() {
        String[] grades = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
        String[] scores = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
        int weight = 0;
        for (String score : scores) {
            scoreWeight.put(score, weight++);
        }

        Map<String, String> cleanGrades = new HashMap<>();
        for (String grade : grades) {
            String[] splitGrades = grade.split(" ");
            if (cleanGrades.containsKey(splitGrades[0])) {
                if (isGreaterGrade(cleanGrades.get(splitGrades[0]), splitGrades[1])) {
                    cleanGrades.put(splitGrades[0], splitGrades[1]);
                }
                continue;
            }

            cleanGrades.put(splitGrades[0], splitGrades[1]);
        }

        Iterator<String> it = sortByValue(cleanGrades).iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            StringBuffer str = new StringBuffer();
            String key = it.next();
            str.append(key);
            str.append(" ");
            str.append(cleanGrades.get(key));
            result.add(str.toString());
        }

        assertThat(result).containsExactly("DS7651 A+", "OS1808 B-", "DB0001 B-", "AI5543 C0", "CA0055 D+", "AI0001 F");
    }

    private boolean isGreaterGrade(String prevGrade, String curGrade) {
        return scoreWeight.get(prevGrade) > scoreWeight.get(curGrade);
    }

    private ArrayList sortByValue(Map<String, String> map) {
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }
        });

        return keyList;
    }
}

/*
class Grade {
    private String schoolNumber;
    private String grade;

    public Grade(String schoolNumber, String grade) {
        this.schoolNumber = schoolNumber;
        this.grade = grade;
    }

    public static Grade of(String grade) {
        String[] grades = grade.split(" ");
        return new Grade(grades[0], grades[1]);
    }
}
*/

