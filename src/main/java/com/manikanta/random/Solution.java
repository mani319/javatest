package com.manikanta.random;

/**
 * Created by Manikanta Tummalapenta on 02 Apr 2020
 */
class Solution {
    public static boolean isHappy(int n) {
        boolean result = false;

        while(true) {
            int number = n;
            n = 0;

            while (number > 0) {
                int rem = (number % 10);
                n += rem * rem;
                number = number / 10;
            }

            if (n == 1) {
                result = true;
                break;
            } else if (n < 5) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 1111111;
        System.out.println(isHappy(n));
    }
}