package com.manikanta.interview.arcesium;

/**
 * Created by Manikanta Tummalapenta on 06 Jan 2020
 */
public class AlphaCesiumPaint {

    private static int getMovesUtil(int[] arr, boolean flag) {
        int moves = 0;

        for (int i = 0; i < arr.length; i++) {

            if (flag) {
                if (arr[i] != 1) {
                    moves++;
                }
            } else {
                if (arr[i] != 0) {
                    moves++;
                }
            }

            flag = !flag;
        }

        return moves;
    }

    static int getMinimumMoves(int[] arr) {

        int moves1 = getMovesUtil(arr, true);
        int moves2 = getMovesUtil(arr, false);

        return Math.min(moves1, moves2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 0, 1, 0};
        System.out.println(getMinimumMoves(arr1));

        int[] arr2 = {1, 1, 0, 0, 0, 1, 0};
        System.out.println(getMinimumMoves(arr2));
    }
}
