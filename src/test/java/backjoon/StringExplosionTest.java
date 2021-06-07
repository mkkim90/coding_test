package backjoon;

import java.util.Scanner;

public class StringExplosionTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String explosion = scan.next();

        String result = explose(s, explosion);
        if (result.length() == 0) System.out.println("FRULA");
        else System.out.println(result);


    }

    private static String explose(String s, String explosion) {
        int idx = s.indexOf(explosion);
        if (idx == -1) return s;
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(0, idx));
        sb.append(s.substring(idx + explosion.length()));
        return explose(sb.toString(), explosion);
    }
}
