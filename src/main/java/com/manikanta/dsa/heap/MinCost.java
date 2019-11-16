package com.manikanta.dsa.heap;

/**
 * Created by Manikanta Tummalapenta on 17 Nov 2019
 *
 * Ref - https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */
public class MinCost {

    int minCost(int[] arr, int n) {
        MinHeap minHeap = new MinHeap(arr, n);
        int totalCost = 0;

        while (minHeap.getHeapSize() > 1) {
            int min1 = minHeap.extractMin();
            int min2 = minHeap.extractMin();

            totalCost += min1 + min2;
            minHeap.insert(min1 + min2);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int len[] = { 4, 3, 2, 6 };
        int size = len.length;

        MinCost minCost = new MinCost();
        System.out.println("Total cost for connecting ropes is " + minCost.minCost(len, size));
    }
}
