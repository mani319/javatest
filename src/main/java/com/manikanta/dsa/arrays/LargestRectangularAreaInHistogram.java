package com.manikanta.dsa.arrays;

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

    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(LargestRectangularAreaInHistogram.largestArea(hist));
    }
}
