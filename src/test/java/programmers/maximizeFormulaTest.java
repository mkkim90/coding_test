package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * expression	result
 * "100-200*300-500+20"	60420
 * "50*6-3*2"	300
 */
public class maximizeFormulaTest {
    private long answer = Long.MIN_VALUE;
    private ArrayList<Long> numbers = new ArrayList<>();
    private ArrayList<String> opers = new ArrayList<>();
    private String[] oper = {"+", "-", "*"};
    private String[] output = new String[3]; // 순열 결과 담을 배열
    private boolean[] visited = new boolean[3];

    @Test
    void solution() {
        String expression = "100-200*300-500+20";
        addNumberOperateList(expression);
        permutation(0, oper.length);
        assertThat(answer).isEqualTo(60420);
    }

    private void addNumberOperateList(String expression) {
        StringBuffer num = new StringBuffer();
        for(char exp : expression.toCharArray()) {
            if("+-*".indexOf(exp) > -1) {
                opers.add(String.valueOf(exp));
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
            } else {
                num.append(exp);
            }
        }
        numbers.add(Long.parseLong(num.toString()));
    }

    private void permutation(int depth, int r) {
        if(depth == r) {
            caculate();
            return;
        }

        for(int i = 0; i < oper.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = oper[i];
                permutation(depth + 1, r);
                visited[i] = false;
            }
        }
    }

    private void caculate() {
        LinkedList<String> oper = new LinkedList<String>(opers);
        LinkedList<Long> num = new LinkedList<Long>(numbers);


        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < oper.size(); j++) {
                if(oper.get(j).equals( output[i])) {
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    num.remove(j);
                    num.remove(j);
                    oper.remove(j);
                    num.add(j, caculateExpression(n1, n2,  output[i]));
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    private long caculateExpression(long n1, long n2, String o) {
        long res = 0;
        switch(o) {
            case "+" :
                res = n1 + n2;
                break;
            case "-" :
                res = n1 -n2;
                break;
            case "*" :
                res = n1 * n2;
                break;
        }
        return res;
    }
}

