package backjoon;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 2
 * 4
 * 500 800 200
 * 300 0 300
 * -100 -200 -400
 * 600 200 300
 * 3
 * 451 234 309
 * 224 334 467
 * 143 246 245
 */
public class StockInvestmentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int nums = sc.nextInt();
        for (int i = 0; i < nums; i++) {
            final int days = sc.nextInt();
            int totalProfit = 0;
            for (int j = 0; j < days; j++) {
                int maxProfit = Math.max(Math.max(sc.nextInt(), sc.nextInt()), sc.nextInt());
                if (maxProfit > 0) totalProfit += maxProfit;
            }
            System.out.println(totalProfit);
        }
    }
}
