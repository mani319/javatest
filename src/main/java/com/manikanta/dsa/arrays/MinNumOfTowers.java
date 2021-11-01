package com.manikanta.dsa.arrays;

import java.util.Arrays;

/**
 * Created by Manikanta Tummalapenta on 30/10/21
 */
public class MinNumOfTowers {

    // Ref - https://www.geeksforgeeks.org/minimum-number-of-towers-required-such-that-every-house-is-in-the-range-of-at-least-one-tower/
    public int minNumOfTowers(int[] houses, int range) {
        int n = houses.length;
        int towers = 0;
        int i = 0;

        // Sort the array
        Arrays.sort(houses);

        while (i < n) {
            // Find middle house from i using range
            int middle = houses[i] + range;
            while (i < n && houses[i] <= middle) {
                i++;
            }

            // Add tower here at middle
            --i;
            towers++;

            // Find last house using range
            int last = houses[i] + range;
            while (i < n && houses[i] <= last) {
                i++;
            }
        }

        return towers;
    }
}
