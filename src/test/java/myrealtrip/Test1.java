package myrealtrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (Math.pow(c,2) == (Math.pow(a,2) + Math.pow(b,2)) && a + b + c == 1000) {
            System.out.println(a*b*c);
        } else {
            System.out.println("조건이 설립하지 않습니다.");
        }
    }
}
