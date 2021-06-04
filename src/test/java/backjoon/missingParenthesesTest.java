package backjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class missingParenthesesTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        List<Integer> nums = new LinkedList<>();
        List<Character> opers = new LinkedList<>();
        StringBuffer num = new StringBuffer();
        /*for (char c : expression.toCharArray()) {
            if ("+-".contains(String.valueOf(c))) {
                opers.add(c);
                nums.add(Integer.parseInt(num.toString()));
                num.setLength(0);
            } else {
                num.append(c);
            }
        }
        nums.add(Integer.parseInt(num.toString()));

        char[] priorityOpers = {'+', '-'};
        for(int i = 0; i < priorityOpers.length; i++) {
            for(int j = 0; j < opers.size(); j++) {
                if(opers.get(j).equals( priorityOpers[i])) {
                    int result = caculate(priorityOpers[i],nums.get(j), nums.get(j+1));
                    nums.remove(j);
                    nums.remove(j);
                    opers.remove(j);
                    nums.add(j, result);
                    j--;
                }
            }
        }

        System.out.println(nums.get(0));*/
        String calcuFormula = expression;
        int result = Integer.MAX_VALUE;

        // 마이너스 기준으로 순자 분리
        String[] plusNumArr = calcuFormula.split("-");

        for (String numbersStr : plusNumArr) {
            int temp = 0;

            // 플러스가 포함된 수식의 경우 계산하여 temp에 저장
            String[] formula = numbersStr.split("\\+");
            for (String formulas : formula)
                temp += Integer.parseInt(formulas);

            // 첫번째 숫자로 초기화
            // Q)  Integer.MAX_VALUE 로 초기 값을 해야하는 이유????
            result = (result ==  Integer.MAX_VALUE) ? temp: result-temp;

        }
        System.out.println(result);
    }

    private static int caculate(char op, int a, int b) {
        if (op == '+') return a + b;
        return a - b;
    }
}
