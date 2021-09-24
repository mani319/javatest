package com.manikanta.dsa.arrays.slidingwindow;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class MinSizeSubarraySumEqK {

    public static void findSubarray(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            System.out.println("No subarray");
            return;
        }
        int resultStart = 0, resultEnd = 0;
        int minLen = Integer.MAX_VALUE, currSum = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {
            currSum += nums[end];

            while (currSum > target) {
                currSum -= nums[start];
                start++;
            }

            if (currSum == target) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    resultStart = start;
                    resultEnd = end;
                }
            }
        }

        System.out.println("Subarray: (" + resultStart + ", " + resultEnd + ")");
    }

    public static void findAllSubarrays(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            System.out.println("No subarray");
            return;
        }
        int currSum = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {
            currSum += nums[end];

            while (currSum > target) {
                currSum -= nums[start];
                start++;
            }

            if (currSum == target) {
                System.out.print("(" + start + ", " + end + ") ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        findSubarray(arr, 7);
        System.out.print("All subarrays: ");
        findAllSubarrays(arr, 7);
        System.out.println();
    }
}
