package com.manikanta.dsa.arrays.binarysearch;

/**
 * Created by Manikanta Tummalapenta on 20/09/21
 */
public class BinarySearch {

    public static int increasingBS(int[] incArr, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);

        if (x == incArr[mid]) {
            return mid;
        } else if (x > incArr[mid]) {
            return increasingBS(incArr, mid + 1, high, x);
        } else {
            return increasingBS(incArr, low, mid - 1, x);
        }
    }

    public static int decreasingBS(int[] decArr, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);

        if (x == decArr[mid]) {
            return mid;
        } else if (x < decArr[mid]) {
            return decreasingBS(decArr, mid + 1, high, x);
        } else {
            return decreasingBS(decArr, low, mid - 1, x);
        }
    }

    public static void main(String[] args) {
        int[] incArr = {1, 3, 4, 5, 7, 9, 11};
        System.out.println(increasingBS(incArr, 0, incArr.length - 1, 4));
        System.out.println(increasingBS(incArr, 0, incArr.length - 1, 9));
        System.out.println(increasingBS(incArr, 0, incArr.length - 1, 10));
        System.out.println(increasingBS(incArr, 0, incArr.length - 1, 1));
        System.out.println(increasingBS(incArr, 0, incArr.length - 1, 11));

        int[] decArr = {9, 7, 5, 3, 1, 0, -4, -8};
        System.out.println(decreasingBS(decArr, 0, decArr.length - 1, 9));
        System.out.println(decreasingBS(decArr, 0, decArr.length - 1, -8));
        System.out.println(decreasingBS(decArr, 0, decArr.length - 1, -1));
        System.out.println(decreasingBS(decArr, 0, decArr.length - 1, 5));
        System.out.println(decreasingBS(decArr, 0, decArr.length - 1, 3));
    }
}
