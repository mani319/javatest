package com.manikanta.dsa.arrays.binarysearch;

/**
 * Created by Manikanta Tummalapenta on 20/09/21
 * <p>
 * Ref - https://www.geeksforgeeks.org/find-element-bitonic-array/ - First stricly increasing and then strictly
 * decreasing array
 */
public class SearchInBitonic {

    public static int searchInBitonic(int[] arr, int x) {
        // pivotInd is index of max elem
        int pivotInd = getPivotIndex(arr, 0, arr.length - 1);

        // If x > pivotInd elem, return -1
        if (x > arr[pivotInd]) {
            return -1;
        } else if (x == arr[pivotInd]) {
            return pivotInd;
        }

        int leftInd = BinarySearch.increasingBS(arr, 0, pivotInd - 1, x);
        if (-1 != leftInd) {
            return leftInd;
        }
        return BinarySearch.decreasingBS(arr, pivotInd + 1, arr.length - 1, x);
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            // search right
            return getPivotIndex(arr, mid + 1, high);
        } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            // search left
            return getPivotIndex(arr, low, mid - 1);
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 1, 2, 3, 4, 5, -2, -3};
        System.out.println("arr " + searchInBitonic(arr, 0));
        System.out.println("arr " + searchInBitonic(arr, -8));
        System.out.println("arr " + searchInBitonic(arr, 1));
        System.out.println("arr " + searchInBitonic(arr, -3));
        System.out.println("arr " + searchInBitonic(arr, -2));
        System.out.println("arr " + searchInBitonic(arr, 5));

        int[] arr1 = {1, 2, 3, 4, -3, -5, -7};
        System.out.println("arr1 " + searchInBitonic(arr1, 5));
        System.out.println("arr1 " + searchInBitonic(arr1, 1));
        System.out.println("arr1 " + searchInBitonic(arr1, -7));
        System.out.println("arr1 " + searchInBitonic(arr1, -5));
        System.out.println("arr1 " + searchInBitonic(arr1, 2));
        System.out.println("arr1 " + searchInBitonic(arr1, 4));
    }
}
