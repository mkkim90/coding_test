package programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankSearchTest {
    private Applicants applicants;

    @BeforeEach
    void setUp() {
        String[] infos = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        applicants = new Applicants(infos);
    }

    @Test
    void solution() {
        Applicant applicant = new Applicant("java backend junior pizza 150");
        assertThat(applicant.getLanguage()).isEqualTo("java");
        assertThat(applicant.getJobGroup()).isEqualTo("backend");
        assertThat(applicant.getCareer()).isEqualTo("junior");
        assertThat(applicant.getSoulFood()).isEqualTo("pizza");
        assertThat(applicant.getScore()).isEqualTo(150);
    }

    @Test
    void applicantsOfTest() {
        String[] infos = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        List<Applicant> list = Applicants.of(infos);
        assertThat(Applicants.of(infos).size()).isEqualTo(6);
        assertThat(list.get(0).getCareer()).isEqualTo("junior");
    }

    @Test
    void isSameLanguageTest() {
        assertThat(applicants.filterSameLanguages("java").size()).isEqualTo(2);
        assertThat(applicants.filterSameLanguages("python").size()).isEqualTo(3);
    }

    @Test
    void isSameJobGroupTest() {
        assertThat(applicants.filterSameJobGroups("backend").size()).isEqualTo(4);
        assertThat(applicants.filterSameJobGroups("frontend").size()).isEqualTo(2);
    }

    @Test
    void filterSameCareersTest() {
        assertThat(applicants.filterSameCareers("junior").size()).isEqualTo(2);
        assertThat(applicants.filterSameCareers("senior").size()).isEqualTo(4);
    }

    @Test
    void filterSameSoulFoodTest() {
        assertThat(applicants.filterSameSoulFood("pizza").size()).isEqualTo(2);
        assertThat(applicants.filterSameSoulFood("chicken").size()).isEqualTo(4);
    }

    @Test
    void moreThanScoreTest() {
        assertThat(applicants.filterMoreThanScore("150").size()).isEqualTo(4);
    }

    @Test
    void filterCountTest() {
        assertThat(applicants.filterCount("java and backend and junior and pizza 100")).isEqualTo(1);
        assertThat(applicants.filterCount("python and frontend and senior and chicken 200")).isEqualTo(1);
        assertThat(applicants.filterCount("cpp and - and senior and pizza 250")).isEqualTo(1);
        assertThat(applicants.filterCount("- and backend and senior and - 150")).isEqualTo(1);
        assertThat(applicants.filterCount("- and - and - and chicken 100")).isEqualTo(2);
        assertThat(applicants.filterCount("- and - and - and - 150")).isEqualTo(4);
    }
}
