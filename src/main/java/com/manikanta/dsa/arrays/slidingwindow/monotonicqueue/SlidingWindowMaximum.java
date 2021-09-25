package com.manikanta.dsa.arrays.slidingwindow.monotonicqueue;

import com.manikanta.dsa.monotonic.DecreasingMonotonicQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 25/09/21
 */
public class SlidingWindowMaximum {

    private static Integer[] windowMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        DecreasingMonotonicQueue mq = new DecreasingMonotonicQueue(arr.length, -1);

        for (int i = 0; i < arr.length; i++) {
            if (i < k - 1) {
                // Push arr[i]
                mq.push(new DecreasingMonotonicQueue.Item(arr[i], i));
            } else {
                // Push arr[i]
                mq.push(new DecreasingMonotonicQueue.Item(arr[i], i));

                // Get max and add to result
                result.add(mq.getMax().getVal());

                // Pop arr[i-k+1]
                mq.popIfSame(arr[i - k + 1]);
            }
        }

        return result.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(windowMax(arr, k)));
    }
}
