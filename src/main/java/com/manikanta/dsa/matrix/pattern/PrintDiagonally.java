package com.manikanta.dsa.matrix.pattern;

/**
 * Created by Manikanta Tummalapenta on 09 Feb 2020
 *
 * Ref - https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
 */
public class PrintDiagonally {
    public static int R,C;

    private static  boolean isValid(int i, int j) {
        if (i < 0 || i >= R || j >= C || j < 0) return false;
        return true;
    }

    private static void diagonalOrder(int[][] mat) {

        for (int k = 0; k < R; k++) {
            int i = k;
            int j = 0;

            while (isValid(i, j)) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }

            System.out.println();
        }

        for (int k = 1; k < C; k++) {
            int i = R-1;
            int j = k;

            while (isValid(i, j)) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}, };

        R = arr.length;
        C = arr[0].length;

        diagonalOrder(arr);
    }
}
