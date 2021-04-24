package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Applicants {
    private List<Applicant> applicantLists;

    public static List<Applicant> of(String[] infos) {
        List<Applicant> applicants = new ArrayList<>();
        for (String info : infos) {
            applicants.add(new Applicant(info));
        }

        return Collections.unmodifiableList(applicants);
    }

    public Applicants(String[] infos) {
        this.applicantLists = of(infos);
    }

    public List<Applicant> filterSameLanguages(String language) {
        if (language.equals("-")) {
            return applicantLists;
        }
        return applicantLists.stream().filter(applicant -> applicant.isSameLanguage(language))
                .collect(Collectors.toList());
    }

    public List<Applicant> filterSameJobGroups(String jobGroup) {
        if (jobGroup.equals("-")) {
            return applicantLists;
        }
        return applicantLists.stream().filter(applicant -> applicant.isSameJobGroup(jobGroup))
                .collect(Collectors.toList());
    }

    public List<Applicant> filterSameCareers(String career) {
        if (career.equals("-")) {
            return applicantLists;
        }
        return applicantLists.stream().filter(applicant -> applicant.isSameCareer(career))
                .collect(Collectors.toList());
    }

    public List<Applicant> filterSameSoulFood(String soulFood) {
        if (soulFood.equals("-")) {
            return applicantLists;
        }
        return applicantLists.stream().filter(applicant -> applicant.isSameSoulFood(soulFood))
                .collect(Collectors.toList());
    }

    public List<Applicant> filterMoreThanScore(String score) {
        if (score.equals("-")) {
            return applicantLists;
        }
        return applicantLists.stream().filter(applicant -> applicant.isMoreThanScore(Integer.parseInt(score)))
                .collect(Collectors.toList());
    }

    public int filterCount(String query) {
        String[] querys = query.split("and");
        String language = querys[0].trim();
        String jobGroup = querys[1].trim();
        String career = querys[2].trim();
        String soulFood = querys[3].trim().split(" ")[0];
        String score = querys[3].trim().split(" ")[1];
        return (int) applicantLists.stream()
                .filter(applicant -> (language.equals("-")) ? true : applicant.isSameLanguage(language))
                .filter(applicant -> (jobGroup.equals("-")) ? true : applicant.isSameJobGroup(jobGroup))
                .filter(applicant -> (career.equals("-")) ? true : applicant.isSameCareer(career))
                .filter(applicant -> (soulFood.equals("-")) ? true : applicant.isSameSoulFood(soulFood))
                .filter(applicant -> (score.equals("-")) ? true : applicant.isMoreThanScore(Integer.parseInt(score)))
                .count();
    }
}
