package com.manikanta.dsa.binarysearch;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 26 Apr 2020
 *
 * Find frequency of an element in a sorted array. (Same as First and Last Position of Element in Sorted Array)
 *
 */
public class frequencyOfElem {

    private static int findFirstOcc(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);

            if (arr[mid] == x && (mid == 0 || arr[mid] > arr[mid-1])) {
                return mid;
            }

            if (arr[mid] >= x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private static int findLastOcc(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);

            if (arr[mid] == x && (mid == arr.length - 1 || arr[mid] < arr[mid+1])) {
                return mid;
            }

            if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private static int getFrequency(int[] arr, int x) {
        int first = findFirstOcc(arr, x);
        if (first == -1) {
            return -1;
        }

        int last = findLastOcc(arr, x);

        return last - first + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};

        Assert.assertEquals(2, getFrequency(arr, 8));
        Assert.assertEquals(4, getFrequency(arr, 2));
        Assert.assertEquals(-1, getFrequency(arr, 5));
    }
}
