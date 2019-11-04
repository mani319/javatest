package com.manikanta.dsa.matrix;

import static java.lang.Math.max;

/**
 * Created by Manikanta Tummalapenta on 04 Nov 2019
 */
public class PathSum {

    // This is optimised to reuse same matrix instead of creating new dp[][]
    private static int maxSumPath(int mat[][], int m, int n) {
        int res = 0;

        // Parse first row
        for (int j = 0; j < n; j++) {
            res = max(res, mat[0][j]);
        }

        // Parse first column except [0][0]
        for (int i = 1; i < m; i++) {
            mat[i][0] += max(
                    mat[i-1][0],
                    mat[i-1][1]);
        }

        // Refill from [1][1] to [m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (j+1 < n) {
                    mat[i][j] += max(max(
                            mat[i - 1][j - 1],
                            mat[i - 1][j]),
                            mat[i-1][j+1]);
                } else {
                    mat[i][j] += max(
                            mat[i - 1][j - 1],
                            mat[i - 1][j]);
                }

                res = max(res, mat[i][j]);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };

        System.out.println(maxSumPath(mat, mat.length, mat[0].length));
    }
}
