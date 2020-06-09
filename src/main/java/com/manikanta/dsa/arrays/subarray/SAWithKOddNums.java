package com.manikanta.dsa.arrays.subarray;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 21 Mar 2020
 */
public class SAWithKOddNums {

    public static int countSubarrays(int a[], int n, int k) {
        int count = 0;
        int[] prefix = new int[n];
        int odd = 0;

        for (int i = 0; i < n; i++) {
            prefix[odd]++;

            if ((a[i] & 1) == 1) {
                odd++;
            }

            if (odd >= k) {
                count += prefix[odd - k];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int a[] = { 2, 2, 5, 6, 9, 2, 11 };
        int n = a.length;
        int k = 2;

        Assert.assertEquals(8, countSubarrays(a, n, k));
    }
}
