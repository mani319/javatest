package com.manikanta.dsa.matrix;

/**
 * Created by Manikanta Tummalapenta on 01/11/21
 */
public class Celebrity {

    public int celebrity(int[][] mat, int n) {

        // First find the probable candidate
        int i = 0, j = n-1;
        while (i < j) {
            // If j knows i, then j is not celeb
            if (mat[j][i] == 1) {
                j--;
            } else {
                // If j doesn't know i, then i is not celeb
                i++;
            }
        }

        // Check if that candidate is celeb or not
        int candidate = i;
        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
