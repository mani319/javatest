package com.manikanta.dsa.arrays;

import com.manikanta.dsa.monotonic.MonotonicQueue;

import java.util.Stack;

/**
 * Created by Manikanta Tummalapenta on 23 Jan 2020
 *
 * Ref - https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class LargestRectangularAreaInHistogram {

    private static Integer largestArea(int[] arr) {
        Integer largestArea = -1;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < arr.length) {

            if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
                // Increment happens only here
                stack.push(i++);
            } else {
                largestArea = getLargestAreaUtil(stack, arr, i, largestArea);
            }
        }

        if (!stack.isEmpty()) {
            largestArea = getLargestAreaUtil(stack, arr, i, largestArea);
        }

        return largestArea;
    }

    private static Integer getLargestAreaUtil(Stack<Integer> stack, int[] arr, int i, Integer largestArea) {
        Integer top = stack.pop();
        Integer areaWithTopAsSmall = arr[top] *
                (stack.isEmpty() ? i : i - stack.peek() - 1);

        return Math.max(largestArea, areaWithTopAsSmall);
    }

    // Ref - https://1e9.medium.com/monotonic-queue-notes-980a019d5793
    public static Integer getLargestAreaUsingMonotonicQueue(int[] arr) {
        int n = arr.length;

        // Default is -1 for left to right. because 0 is starting index
        MonotonicQueue leftToRightMQ = new MonotonicQueue(n, -1);
        for (int i = 0; i < n; i++) {
            leftToRightMQ.pushIncreasingForNearest(new MonotonicQueue.Item(arr[i], i));
        }

        // Default is n for right to left. because n-1 is ending index
        MonotonicQueue rightToLeftMQ = new MonotonicQueue(n, n);
        for (int i = n-1; i >= 0; i--) {
            rightToLeftMQ.pushIncreasingForNearest(new MonotonicQueue.Item(arr[i], i));
        }

        // Find left nearest and right nearest for each elem which gives width.
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightToLeftMQ.nearest[i] - leftToRightMQ.nearest[i] - 1;
            int currArea = width * arr[i];

            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestArea(hist));
        System.out.println(getLargestAreaUsingMonotonicQueue(hist));
    }
}
