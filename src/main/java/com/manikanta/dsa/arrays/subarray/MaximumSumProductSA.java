package com.manikanta.dsa.arrays.subarray;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 22 Mar 2020
 */
public class MaximumSumProductSA {

    static int maxSumSubarray(int[] arr) {
        int maxEndingHere = 0, maxSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];

            if (maxEndingHere > maxSum) {
                maxSum = maxEndingHere;
                start = tempStart;
                end = i;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStart = i+1;
            }
        }

        return end - start + 1;
    }

    static int maxProductSubarray(int[] arr) {
        int maxEndingHere = 1, minEndingHere = 1, maxProd = 1;

        for (int i = 0; i < arr.length; i++) {

            switch (Long.signum(arr[i])) {
                case 1: // Positive
                    maxEndingHere = maxEndingHere * arr[i];
                    minEndingHere = Math.min(minEndingHere * arr[i], 1);
                    break;

                case -1: // Negative
                    int tempMaxEndingHere = maxEndingHere;

                    maxEndingHere = Math.max(minEndingHere * arr[i], 1);
                    minEndingHere = tempMaxEndingHere * arr[i];
                    break;

                case 0: // Zero
                    maxEndingHere = 1;
                    minEndingHere = 1;
                    break;
            }

            if (maxEndingHere > maxProd) {
                maxProd = maxEndingHere;
            }
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 0, 1, 5, -3};
        Assert.assertEquals(6, maxSumSubarray(array));

        int[] array2 = {1, -2, -3, 0, 7, -8, -2};
        Assert.assertEquals(112, maxProductSubarray(array2));
    }
}
