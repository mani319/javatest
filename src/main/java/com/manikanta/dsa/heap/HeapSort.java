package com.manikanta.dsa.heap;

import com.manikanta.dsa.MiscUtil;

/**
 * Created by Manikanta Tummalapenta on 17 Nov 2019
 */
public class HeapSort {

    void sortDec(int[] arr) {
        int n = arr.length;
        MinHeap minHeap = new MinHeap(arr, n);

        for (int i = n-1; i >= 0; i--) {
            MiscUtil.swap(arr, 0, i);

            minHeap.heapify(i, 0);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort hs = new HeapSort();
        hs.sortDec(arr);

        System.out.println("Sorted array is");
        MiscUtil.printArray(arr);
    }
}
