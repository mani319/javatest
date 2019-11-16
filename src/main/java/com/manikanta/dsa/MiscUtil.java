package com.manikanta.dsa;

/**
 * Created by Manikanta Tummalapenta on 17 Nov 2019
 */
public class MiscUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
