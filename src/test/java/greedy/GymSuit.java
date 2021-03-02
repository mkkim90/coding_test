package greedy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class GymSuit {

    @Test
    void solution2() {
        int[] reserve = {1};
        int[] lost = {3};
        int n = 3;
        int answer = n - lost.length;

        //여분 체육복이 있지만 체육복을 잃어버린 학생을 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        //체육복을 reserve
        for (int lostPerson : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lostPerson + 1 || reserve[i] == lostPerson - 1) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
    }

    @Test
    void solution3() {
        int[] reserve = {1};
        int[] lost = {3};
        int n = 3;
        int answer = n - lost.length;
        HashSet<Integer> ko = new HashSet<Integer>();
        for (int k : reserve) {
            ko.add(k);
        }
        for (int i = 0; i < lost.length; i++) {
            if (ko.contains(lost[i])) {
                //System.out.println("내껀내가입지");
                answer++;
                ko.remove(lost[i]);
                lost[i] = -1;
            }
        }


        for (int i = 0; i < lost.length; i++) {
            if (ko.contains(lost[i] - 1)) {
                answer++;
                ko.remove(lost[i] - 1);
            } else if (ko.contains(lost[i] + 1)) {
                answer++;
                ko.remove(lost[i] + 1);
            }
        }
    }
}
