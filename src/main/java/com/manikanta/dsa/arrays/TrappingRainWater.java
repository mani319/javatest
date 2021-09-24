package com.manikanta.dsa.arrays;

import com.manikanta.dsa.monotonic.MonotonicQueue;

import java.util.Arrays;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class TrappingRainWater {

    // Find next bigger on left and right for width?
    public static int trap(int[] height) {
        int n = height.length;

        // leftToRight pushIncreasing - insert max on left for each curr
        MonotonicQueue leftToRightMQ = new MonotonicQueue(n, -1);
        for (int i = 0; i < n; i++) {
            leftToRightMQ.pushDecreasingForOverall(new MonotonicQueue.Item(height[i], i));
        }

        // rightToLeft pushIncreasing - insert max on right for each curr
        MonotonicQueue rightToLeftMQ = new MonotonicQueue(n, n);
        for (int i = n - 1; i >= 0; i--) {
            rightToLeftMQ.pushDecreasingForOverall(new MonotonicQueue.Item(height[i], i));
        }

        // Min(leftMax, rightMax) - currHeight is water trapped at each height.
        int water = 0;
        for (int i = 0; i < n; i++) {
            if (leftToRightMQ.nearest[i] >= 0 && rightToLeftMQ.nearest[i] < n) {
                water += Math.min(height[leftToRightMQ.nearest[i]], height[rightToLeftMQ.nearest[i]]) - height[i];
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(h));
        int[] h1 = {4,2,0,3,2,5};
        System.out.println(trap(h1));
    }
}
