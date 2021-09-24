package com.manikanta.dsa.arrays.slidingwindow;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class MinSumKSizeSubarray {

    public static void findSubarray(int[] arr, int k) {
        int n = arr.length;
        int currSum = 0, minSum = Integer.MAX_VALUE;
        int resultStart = 0, resultEnd = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
            resultStart = 0;
            resultEnd = k - 1;
        }

        for (int start = 0, end = k; end < n; end++) {
            currSum += arr[end] - arr[start];
            start++;

            if (currSum < minSum) {
                minSum = currSum;
                resultStart = start;
                resultEnd = end;
            }
        }

        System.out.println("Subarray: (" + resultStart + ", " + resultEnd + ")");
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1};
        int k = 3;

        findSubarray(arr, k);
    }
}
