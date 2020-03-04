package com.manikanta.dsa.matrix.pattern;

/**
 * Created by Manikanta Tummalapenta on 09 Feb 2020
 *
 * Ref - http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class PrintSpirally {

    /* Logic
    i = 0, j = 0

    (0, 0) to (0, n-1)     -> j = 0:n-1, i = constant --> next iteration i++
    (1, n-1) to (m-1, n-1) -> i = 1:m-1, j = constant --> next iteration n--
    (m-1, n-2) to (m-1, 0) -> j = n-2:0, i = constant --> next iteration m--
    (m-2, 0) to (1, 0)     -> i = m-2:1, j = constant --> next iteration j++
    (1, 1) to (1, n-2)
    ....
     */

    private static void spiralPrint(int m, int n, int mat[][]) {
        int i = 0, j = 0, k;

        while (i < m && j < n) {

            for (k = j; k < n; k++) {
                System.out.print(mat[i][k] + " ");
            }
            i++;

            for (k = i; k < m; k++) {
                System.out.print(mat[k][n-1] + " ");
            }
            n--;

            if (i < m) {
                for (k = n - 1; k >= j; k--) {
                    System.out.print(mat[m-1][k] + " ");
                }
                m--;
            }

            if (j < n) {
                for (k = m - 1; k >= i; k--) {
                    System.out.print(mat[k][j] + " ");
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                      { 7, 8, 9, 10, 11, 12 },
                      { 13, 14, 15, 16, 17, 18 } };
        spiralPrint(R, C, a);
    }
}
