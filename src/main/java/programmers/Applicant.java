package programmers;

public class Applicant {
    private String language;
    private String jobGroup;
    private String career;
    private String soulFood;
    private int score;

    public Applicant(String s) {
        String[] strs = s.split(" ");
        this.language = strs[0];
        this.jobGroup = strs[1];
        this.career = strs[2];
        this.soulFood = strs[3];
        this.score = Integer.parseInt(strs[4]);
    }

    public boolean isSameLanguage(String language) {
        return this.language.equals(language);
    }


    public String getLanguage() {
        return language;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public String getCareer() {
        return career;
    }

    public String getSoulFood() {
        return soulFood;
    }

    public int getScore() {
        return score;
    }

    public boolean isSameJobGroup(String jobGroup) {
        return this.jobGroup.equals(jobGroup);
    }

    public boolean isSameCareer(String career) {
        return this.career.equals(career);
    }

    public boolean isSameSoulFood(String soulFood) {
        return this.soulFood.equals(soulFood);
    }

    public boolean isMoreThanScore(int score) {
        return this.score >= score;
    }
}
