package com.manikanta.dsa.arrays.subarray;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 21 Mar 2020
 */
public class NoOfSAWithSumProductLessThanK {

    static int countSumSubarrays(int arr[], int k) {
        int count = 0, windowSum = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= k) {
                windowSum -= arr[windowStart];
                windowStart++;
            }

            count += windowEnd - windowStart + 1;
        }

        return count;
    }

    static int countProductSubarrays(int arr[], int k) {
        int count = 0, windowProduct = 1, windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowProduct *= arr[windowEnd];

            while (windowProduct >= k) {
                windowProduct /= arr[windowStart];
                windowStart++;
            }

            count += windowEnd - windowStart + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int array[] = { 1, 11, 2, 3, 15 };

        Assert.assertEquals(4, countSumSubarrays(array, 10));
        Assert.assertEquals(6, countProductSubarrays(array, 15));
    }
}
