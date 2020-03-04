package com.manikanta.interview.arcesium;

/**
 * Created by Manikanta Tummalapenta on 06 Jan 2020
 */
public class RaghavDiscount {

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b) {
        return (a*b)/gcd(a, b);
    }

    static long getMaxDiscount(long n, long x, long y, long a, long b) {

        long d1 = n / x;
        long d2 = n / y;

        long d3 = n / lcm(x, y);

        return (((d1 - d3) * a) + ((d2 - d3) * b) + (d3 * Math.max(a, b)));
    }

    static long getMaxDiscount1(long n, long x, long y, long a, long b) {
        int maxD = 0;

        for (long i = 1; i <= n; i++) {
            if (i % x == 0 && i % y == 0) {
                maxD += Math.max(a, b);
            } else if (i % x == 0) {
                maxD += a;
            } else if (i % y == 0) {
                maxD += b;
            }
        }

        return maxD;
    }

    public static void main(String[] args) {
        System.out.println(getMaxDiscount(32, 4, 8, 1, 2));
        System.out.println(getMaxDiscount1(32, 4, 8, 1, 2));
    }
}
