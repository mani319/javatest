package com.manikanta.codechef;

import java.util.Scanner;

/**
 * Created by Manikanta Tummalapenta on 30 Sep 2019
 *
 * Problem - https://www.codechef.com/problems/NUM239
 */
public class NUM239 {

    private static boolean isPrettyNumber(int num) {
        int reminder = num % 10;
        return  (reminder == 2 || reminder == 3 || reminder == 9);
    }

    private static int getPrettyNumbers1(int l, int r) {
        int prettyNumbers = 0;
        while (l % 10 != 0) {
            if (isPrettyNumber(l)) {
                prettyNumbers += 1;
            }
            l += 1;
        }

        while (r % 10 != 0) {
            if (isPrettyNumber(r)) {
                prettyNumbers += 1;
            }
            r -= 1;
        }

        int diff = r - l;
        prettyNumbers += ((diff / 10) * 3);

        return prettyNumbers;
    }

    private static int getPrettyNumbers2(int l, int r) {
        int prettyNumbers = 0;

        for (int i = l; i <= r; i++) {
            if (isPrettyNumber(i)) {
                prettyNumbers += 1;
            }
        }

        return prettyNumbers;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            System.out.println(getPrettyNumbers1(l, r));
        }
    }
}
