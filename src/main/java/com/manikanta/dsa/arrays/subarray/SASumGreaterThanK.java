package com.manikanta.dsa.arrays.subarray;

/**
 * Created by Manikanta Tummalapenta on 14 May 2020
 */
public class SASumGreaterThanK {

    int minLenSubArray(int[] arr, int k) {
        int n = arr.length;
        int currSum = 0, minLen = Integer.MAX_VALUE;

        for (int start = 0, end = 0; end < n; ) {

            while (currSum <= k && end < n) {
                currSum += arr[end++];
            }

            while (currSum > k && start < n) {
                minLen = Math.min(minLen, end - start + 1);
                currSum -= arr[start++];
            }
        }

        return minLen;
    }
}
