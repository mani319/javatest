package com.manikanta.dsa.heap;

import com.manikanta.dsa.MiscUtil;

/**
 * Created by Manikanta Tummalapenta on 17 Nov 2019
 */
public class MinHeap {
    int[] harr;
    int heapSize;
    int capacity;

    public MinHeap(int[] arr, int heapSize) {
        this.harr = arr;
        this.heapSize = heapSize;
        this.capacity = heapSize;

        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    int extractMin() {
        if (this.heapSize <= 0)
            return -1;

        if (1 == this.heapSize) {
            this.heapSize--;
            return this.harr[0];
        }

        int min = this.harr[0];
        this.harr[0] = this.harr[this.heapSize - 1];
        this.heapSize--;

        heapify(0);

        return min;
    }

    void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int min = i;

        if (l < this.heapSize && this.harr[l] < this.harr[i])
            min = l;
        if (r < this.heapSize && this.harr[r] < this.harr[min])
            min = r;

        if (min != i) {
            MiscUtil.swap(this.harr, i, min);
            heapify(min);
        }
    }

    void insert(int value) {
        if (this.heapSize == this.capacity) {
            return;
        }

        this.heapSize++;
        int i = this.heapSize - 1;
        this.harr[i] = value;

        while (i != 0 && this.harr[parent(i)] > this.harr[i]) {
            MiscUtil.swap(this.harr, i, parent(i));
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

    public int[] getHarr() {
        return this.harr;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
