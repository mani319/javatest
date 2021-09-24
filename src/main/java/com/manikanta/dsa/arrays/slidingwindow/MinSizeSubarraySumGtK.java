package com.manikanta.dsa.arrays.slidingwindow;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class MinSizeSubarraySumGtK {

    public static void findSubarrayPosNums(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            System.out.println("No subarray");
            return;
        }
        int resultStart = 0, resultEnd = 0;
        int currSum = 0, minLen = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < nums.length; end++) {
            currSum += nums[end];

            while (currSum >= target) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    resultStart = start;
                    resultEnd = end;
                }
                currSum -= nums[start];
                start++;
            }
        }

        if (resultEnd == resultStart && nums[resultStart] < target) {
            System.out.println("No subarray");
            return;
        }
        System.out.println("Subarray: (" + resultStart + ", " + resultEnd + ")");
    }

    public static void findSubarrayWithNegNums(int[] nums, int target) {

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        findSubarrayPosNums(arr, 7);
    }
}
