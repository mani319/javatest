package com.manikanta.dsa.heap;

import com.manikanta.dsa.MiscUtil;

import java.util.Collections;

/**
 * Created by Manikanta Tummalapenta on 17 Nov 2019
 */
public class MinHeap {
    int[] harr;
    int heapSize;
    int capacity;

    public MinHeap(int[] arr, int heapSize) {
        harr = arr;
        heapSize = heapSize;
        capacity = heapSize;

        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    int extractMin() {
        if (heapSize <= 0)
            return -1;

        if (1 == heapSize) {
            heapSize--;
            return harr[0];
        }

        int min = harr[0];
        harr[0] = harr[heapSize - 1];
        heapSize--;

        heapify(0);

        return min;
    }

    void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int min = i;

        if (l < heapSize && harr[l] < harr[i])
            min = l;
        if (r < heapSize && harr[r] < harr[i])
            min = r;

        if (min != i) {
            MiscUtil.swap(harr, i, min);
            heapify(min);
        }
    }

    void insert(int value) {
        if (heapSize == capacity) {
            return;
        }

        int i = heapSize - 1;
        harr[i] = value;
        heapSize++;

        while (i != 0 && harr[parent(i)] > harr[i]) {
            MiscUtil.swap(harr, i, parent(i));
            i = parent(i);
        }
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }
}
